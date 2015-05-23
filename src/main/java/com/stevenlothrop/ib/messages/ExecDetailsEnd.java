package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ExecDetailsEnd extends Struct implements IBMessage {
    public final int reqId;

    public ExecDetailsEnd(int reqId) {
        this.reqId = reqId;
    }
}
