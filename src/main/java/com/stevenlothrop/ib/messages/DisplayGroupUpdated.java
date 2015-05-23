package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class DisplayGroupUpdated extends Struct implements IBMessage {
    public final int reqId;
    public final String contractInfo;

    public DisplayGroupUpdated(int reqId, String contractInfo) {
        this.reqId = reqId;
        this.contractInfo = contractInfo;
    }
}
