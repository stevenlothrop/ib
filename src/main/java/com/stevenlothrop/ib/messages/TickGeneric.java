package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class TickGeneric extends Struct implements IBMessage {
    public final int tickerId;
    public final int tickType;
    public final double value;

    public TickGeneric(int tickerId, int tickType, double value) {
        this.tickerId = tickerId;
        this.tickType = tickType;
        this.value = value;
    }
}
