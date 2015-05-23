package com.stevenlothrop.concurrent;

public interface HashSetSubscriber<T> extends Listener<T>  {
    void on(Iterable<T> t);
}
