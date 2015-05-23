package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class UpdateMktDepthL2 extends Struct implements IBMessage {
    public final int tickerId;
    public final int position;
    public final String marketMaker;
    public final int operation;
    public final int side;
    public final double price;
    public final int size;

    public UpdateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price, int size) {
        this.tickerId = tickerId;
        this.position = position;
        this.marketMaker = marketMaker;
        this.operation = operation;
        this.side = side;
        this.price = price;
        this.size = size;
    }
}
