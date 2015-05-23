package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class TickPrice extends Struct implements IBMessage {
    public final int tickerId;
    public final int field;
    public final double price;
    public final int canAutoExecute;

    public TickPrice(int tickerId, int field, double price, int canAutoExecute) {
        this.tickerId = tickerId;
        this.field = field;
        this.price = price;
        this.canAutoExecute = canAutoExecute;
    }
}
