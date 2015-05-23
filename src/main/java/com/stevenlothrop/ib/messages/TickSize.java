package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class TickSize extends Struct implements IBMessage {
    public final int tickerId;
    public final int field;
    public final int size;

    public TickSize(int tickerId, int field, int size) {
        this.tickerId = tickerId;
        this.field = field;
        this.size = size;
    }
}
