package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ErrorWithException extends Struct implements IBMessage {
    public final Exception e;

    public ErrorWithException(Exception e) {
        this.e = e;
    }
}
