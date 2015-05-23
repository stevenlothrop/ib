package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class UpdateNewsBulletin extends Struct implements IBMessage {
    public final int msgId;
    public final int msgType;
    public final String message;
    public final String origExchange;

    public UpdateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.message = message;
        this.origExchange = origExchange;
    }
}
