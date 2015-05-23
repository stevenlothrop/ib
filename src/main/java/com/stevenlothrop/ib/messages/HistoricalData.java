package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class HistoricalData extends Struct implements IBMessage {
    public final int reqId;
    public final String date;
    public final double open;
    public final double high;
    public final double low;
    public final double close;
    public final int volume;
    public final int count;
    public final double wap;
    public final boolean hasGaps;

    public HistoricalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double wap, boolean hasGaps) {
        this.reqId = reqId;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.count = count;
        this.wap = wap;
        this.hasGaps = hasGaps;
    }
}
