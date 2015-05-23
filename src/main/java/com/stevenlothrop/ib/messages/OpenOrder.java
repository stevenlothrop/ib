package com.stevenlothrop.ib.messages;

import com.ib.client.Contract;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.stevenlothrop.util.Struct;

public class OpenOrder extends Struct implements IBMessage {
    public final int orderId;
    public final Contract contract;
    public final Order order;
    public final OrderState orderState;

    public OpenOrder(int orderId, Contract contract, Order order, OrderState orderState) {
        this.orderId = orderId;
        this.contract = contract;
        this.order = order;
        this.orderState = orderState;
    }
}
