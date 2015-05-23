package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class UpdateAccountTime extends Struct implements IBMessage {
    public final String timeStamp;

    public UpdateAccountTime(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
