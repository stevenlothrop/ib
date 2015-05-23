package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ScannerDataEnd extends Struct implements IBMessage {
    public final int reqId;

    public ScannerDataEnd(int reqId) {
        this.reqId = reqId;
    }
}
