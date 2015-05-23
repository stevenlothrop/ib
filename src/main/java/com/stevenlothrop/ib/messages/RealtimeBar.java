package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class RealtimeBar extends Struct implements IBMessage {
    public final int reqId;
    public final long time;
    public final double open;
    public final double high;
    public final double low;
    public final double close;
    public final long volume;
    public final double wap;
    public final int count;

    public RealtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {
        this.reqId = reqId;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.wap = wap;
        this.count = count;
    }
}
