package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ErrorWithCode extends Struct implements IBMessage {
    public final int id;
    public final int errorCode;
    public final String errorMsg;

    public ErrorWithCode(int id, int errorCode, String errorMsg) {
        this.id = id;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
