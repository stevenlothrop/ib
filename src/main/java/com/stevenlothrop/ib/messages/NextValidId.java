package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;


public class NextValidId extends Struct implements IBMessage {
    public final int orderId;

    public NextValidId(int orderId) {
        this.orderId = orderId;
    }
}
