package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class TickSnapshotEnd extends Struct implements IBMessage {
    public final int reqId;

    public TickSnapshotEnd(int reqId) {

        this.reqId = reqId;
    }
}
