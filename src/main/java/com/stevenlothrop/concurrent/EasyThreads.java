package com.stevenlothrop.concurrent;

import java.util.ArrayList;
import java.util.List;

public class EasyThreads {
    private List<EasyThread> threads = new ArrayList<>();
    public EasyThread starterThread = new EasyThread(t -> t.printStackTrace());

    public EasyThread create(EasyThread.ExceptionCallback exceptionCallback){
        EasyThread e = new EasyThread(exceptionCallback);
        threads.add(e);
        return e;
    }
    public EasyThread createAndSwallowExceptions(){
        return create(t -> {});
    }
    public EasyThread createAndSoutExceptions(){
        return create(t -> t.printStackTrace());
    }

    public void wrap(EasyThread easyThread){
        threads.add(easyThread);
    }

    public void start(){
        threads.forEach(EasyThread::start);
        starterThread.start();
    }

}
