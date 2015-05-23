package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ContractDetailsEnd extends Struct implements IBMessage {
    public final int reqId;

    public ContractDetailsEnd(int reqId) {
        this.reqId = reqId;
    }
}
