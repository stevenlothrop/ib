package com.stevenlothrop.ib;

public interface Callback<T>  {
    void on(T msg);
}
