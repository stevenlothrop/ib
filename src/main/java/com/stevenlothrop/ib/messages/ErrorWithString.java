package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ErrorWithString extends Struct implements IBMessage {
    public final String str;

    public ErrorWithString(String str) {
        this.str = str;
    }
}
