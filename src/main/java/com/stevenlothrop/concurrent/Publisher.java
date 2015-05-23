package com.stevenlothrop.concurrent;

public interface Publisher <T>{
    void publish(T t);
    void publish(Iterable<T> t);
}
