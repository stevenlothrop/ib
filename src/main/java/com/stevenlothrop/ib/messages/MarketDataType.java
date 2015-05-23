package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class MarketDataType extends Struct implements IBMessage {
    public final int reqId;
    public final int marketDataType;

    public MarketDataType(int reqId, int marketDataType) {
        this.reqId = reqId;
        this.marketDataType = marketDataType;
    }
}
