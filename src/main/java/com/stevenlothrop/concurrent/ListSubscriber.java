package com.stevenlothrop.concurrent;

public interface ListSubscriber<T> extends Listener<T>  {
    void on(Iterable<T> t);
}
