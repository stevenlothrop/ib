package com.stevenlothrop.util;

public class Sequence {
    private int current;

    public Sequence(int start) {
        this.current = start;
    }

    public int next(){
        current += 1;
        return current;
    }
}
