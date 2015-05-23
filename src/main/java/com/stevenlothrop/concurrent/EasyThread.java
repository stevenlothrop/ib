package com.stevenlothrop.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EasyThread {
    private final Thread thread;
    private final Lock lock = new ReentrantLock();
    private final Condition waiter = lock.newCondition();

    List<Runnable> runnables = new ArrayList<>();
    private boolean isRunning = true;

    public EasyThread(ExceptionCallback exceptionCallback) {
        this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                HashMap<String, String> hm = new HashMap<>();
                AtomicInteger atomicInteger = new AtomicInteger(1);
                while (isRunning) {
                    List<Runnable> toExecute;
                    List<Runnable> buffer = new ArrayList<>();
                    try {
                        lock.lock();
                        while (runnables.isEmpty() && isRunning) {
                            try {
                                waiter.await();
                            } catch (InterruptedException e) {
                                exceptionCallback.on(e);
                            }
                        }
                        toExecute = runnables;
                        runnables = buffer;
                    } finally {
                        lock.unlock();
                    }

                    for (Runnable aToExecute : toExecute) {
                        try {
                            aToExecute.run();
                        } catch (Throwable t) {
                            exceptionCallback.on(t);
                        }
                    }
                }
            }
        });
    }

    public void execute(Runnable r) {
        lock.lock();
        try {
            runnables.add(r);
            waiter.signal();
        } finally {
            lock.unlock();
        }
    }

    public void execute(Iterable<Runnable> rs) {
        try {
            lock.lock();
            for (Runnable r : rs) {
                runnables.add(r);
            }
            waiter.signal();
        } finally {
            lock.unlock();
        }
    }

    public void start() {
        thread.start();
    }

    public void dispose() {
        try {
            lock.lock();
            isRunning = false;
            waiter.signal();
        } finally {
            lock.unlock();
        }
    }

    public <T> void subscribe(Channel<T> channel, Subscriber<T> on) {
        channel.addSubscription(new Subscription<T>(this, on));
    }

    public <T> void subscribeList(Channel<T> channel, ListSubscriber<T> on) {
        channel.addSubscription(new SubscriptionList<T>(this, on));
    }

    public <T> void subscribeSet(Channel<T> channel, HashSetSubscriber<T> on, HashKeyFunction<T> hashCodeFunction) {
        channel.addSubscription(new SubscriptionHashSet<T>(this, on, hashCodeFunction));
    }

    public interface ExceptionCallback {
        void on(Throwable t);
    }

    public static abstract class SubscriptionBase<T> {
        abstract void transferWorkToSubscriberThread(T t);

        abstract void transferWorkToSubscriberThread(Iterable<T> t);
    }

    public static class Subscription<T> extends SubscriptionBase<T> {
        private EasyThread easyThread;
        private Subscriber run;

        public <T> Subscription(EasyThread easyThread, Subscriber<T> run) {
            this.easyThread = easyThread;
            this.run = run;
        }

        @Override
        void transferWorkToSubscriberThread(T t) {
            easyThread.execute(() -> run.on(t));
        }

        @Override
        void transferWorkToSubscriberThread(Iterable<T> ts) {
            List<Runnable> rs = new ArrayList<>();
            for (T t : ts) {
                rs.add(() -> run.on(t));
            }
            easyThread.execute(rs);
        }
    }

    public static class SubscriptionList<T> extends SubscriptionBase<T> {
        private final EasyThread easyThread;

        private final ListSubscriber run;
        private Lock lock = new ReentrantLock();

        private boolean enqueuedOnSubscriberThread = false;
        private List<T> ts = new ArrayList<>();

        public <T> SubscriptionList(EasyThread easyThread, ListSubscriber<T> run) {
            this.easyThread = easyThread;
            this.run = run;
        }

        @Override
        void transferWorkToSubscriberThread(T t) {
            try {
                lock.lock();
                ts.add(t);
                if (!enqueuedOnSubscriberThread) {
                    easyThread.execute(doWorkOnSubscribingThread());
                    enqueuedOnSubscriberThread = true;
                }
            } finally {
                lock.unlock();
            }
        }

        @Override
        void transferWorkToSubscriberThread(Iterable<T> t) {
            try {
                lock.lock();
                for (T aT : t) {
                    ts.add(aT);
                }
                if (!enqueuedOnSubscriberThread) {
                    easyThread.execute(doWorkOnSubscribingThread());
                    enqueuedOnSubscriberThread = true;
                }
            } finally {
                lock.unlock();
            }
        }

        public Runnable doWorkOnSubscribingThread() {
            return () -> {
                List<T> currentTs;
                List<T> newTs = new ArrayList<>();
                try {
                    lock.lock();
                    currentTs = ts;
                    ts = newTs;
                    enqueuedOnSubscriberThread = false;
                } finally {
                    lock.unlock();
                }
                if (currentTs != null) {
                    run.on(currentTs);
                }
            };
        }
    }

    public static class SubscriptionHashSet<T> extends SubscriptionBase<T> {
        private final HashSetSubscriber run;

        private Lock lock = new ReentrantLock();

        private boolean enqueuedOnSubscriberThread = false;
        private Map<String, T> ts = new HashMap<>();

        private final EasyThread easyThread;
        private final HashKeyFunction hashKeyFunction;

        public <T> SubscriptionHashSet(EasyThread easyThread, HashSetSubscriber<T> run, HashKeyFunction<T> hashKeyFunction) {
            this.easyThread = easyThread;
            this.run = run;
            this.hashKeyFunction = hashKeyFunction;
        }

        @Override
        void transferWorkToSubscriberThread(T t) {
            try {
                lock.lock();
                ts.put(hashKeyFunction.hashKey(t), t);
                if (!enqueuedOnSubscriberThread) {
                    easyThread.execute(doWorkOnSubscribingThread());
                    enqueuedOnSubscriberThread = true;
                }
            } finally {
                lock.unlock();
            }
        }

        @Override
        void transferWorkToSubscriberThread(Iterable<T> t) {
            try {
                lock.lock();
                for (T aT : t) {
                    ts.put(hashKeyFunction.hashKey(aT), aT);
                }
                if (!enqueuedOnSubscriberThread) {
                    easyThread.execute(doWorkOnSubscribingThread());
                    enqueuedOnSubscriberThread = true;
                }
            } finally {
                lock.unlock();
            }
        }

        public Runnable doWorkOnSubscribingThread() {
            return () -> {
                Map<String, T> currentTs;
                Map<String, T> newTs = new HashMap<>();
                try {
                    lock.lock();
                    currentTs = ts;
                    ts = newTs;
                    enqueuedOnSubscriberThread = false;
                } finally {
                    lock.unlock();
                }
                if (currentTs != null) {
                    run.on(currentTs.entrySet());
                }
            };
        }
    }

    public interface HashKeyFunction<T> {
        String hashKey(T t);
    }
}
