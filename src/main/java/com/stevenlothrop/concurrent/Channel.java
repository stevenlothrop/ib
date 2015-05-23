package com.stevenlothrop.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Channel<T> implements Publisher<T>{

    private final List<EasyThread.SubscriptionBase<T>> subscriptions = new ArrayList<>();
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock read = reentrantReadWriteLock.readLock();
    private final ReentrantReadWriteLock.WriteLock write = reentrantReadWriteLock.writeLock();

    @Override
    public void publish(T t) {
        try {
            read.lock();
            for (EasyThread.SubscriptionBase<T> subscription : subscriptions) {
                subscription.transferWorkToSubscriberThread(t);
            }
        } finally{
            read.unlock();
        }
    }

    @Override
    public void publish(Iterable<T> t) {
        try {
            read.lock();
            for (EasyThread.SubscriptionBase<T> subscription : subscriptions) {
                subscription.transferWorkToSubscriberThread(t);
            }
        } finally{
            read.unlock();
        }
    }

    public void addSubscription(EasyThread.Subscription<T> on) {
        try{
            write.lock();
            subscriptions.add(on);
        }finally{
            write.unlock();
        }
    }
    public void addSubscription(EasyThread.SubscriptionList<T> on) {
        try{
            write.lock();
            subscriptions.add(on);
        }finally{
            write.unlock();
        }
    }
    public void addSubscription(EasyThread.SubscriptionHashSet<T> on) {
        try{
            write.lock();
            subscriptions.add(on);
        }finally{
            write.unlock();
        }
    }
}
