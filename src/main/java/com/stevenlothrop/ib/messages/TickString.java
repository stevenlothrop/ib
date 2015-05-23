package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class TickString extends Struct implements IBMessage {
    public final int tickerId;
    public final int tickType;
    public final String value;

    public TickString(int tickerId, int tickType, String value) {
        this.tickerId = tickerId;
        this.tickType = tickType;
        this.value = value;
    }
}
