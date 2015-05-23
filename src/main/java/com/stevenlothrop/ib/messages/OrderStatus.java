package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class OrderStatus extends Struct implements IBMessage {
    public final int orderId;
    public final String status;
    public final int filled;
    public final int remaining;
    public final double avgFillPrice;
    public final int permId;
    public final int parentId;
    public final double lastFillPrice;
    public final int clientId;
    public final String whyHeld;

    public OrderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId, String whyHeld) {
        this.orderId = orderId;
        this.status = status;
        this.filled = filled;
        this.remaining = remaining;
        this.avgFillPrice = avgFillPrice;
        this.permId = permId;
        this.parentId = parentId;
        this.lastFillPrice = lastFillPrice;
        this.clientId = clientId;
        this.whyHeld = whyHeld;
    }
}
