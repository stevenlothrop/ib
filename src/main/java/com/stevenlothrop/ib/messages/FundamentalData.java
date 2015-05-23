package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class FundamentalData extends Struct implements IBMessage {
    public final int reqId;
    public final String data;

    public FundamentalData(int reqId, String data) {
        this.reqId = reqId;
        this.data = data;
    }
}
