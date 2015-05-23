package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class UpdateMktDepth extends Struct implements IBMessage {
    public final int tickerId;
    public final int position;
    public final int operation;
    public final int side;
    public final double price;
    public final int size;

    public UpdateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
        this.tickerId = tickerId;
        this.position = position;
        this.operation = operation;
        this.side = side;
        this.price = price;
        this.size = size;
    }
}
