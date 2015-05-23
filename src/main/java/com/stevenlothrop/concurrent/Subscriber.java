package com.stevenlothrop.concurrent;

public interface Subscriber<T> extends Listener<T>{
    void on(T t);
}
