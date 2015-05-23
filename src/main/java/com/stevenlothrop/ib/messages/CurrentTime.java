package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class CurrentTime extends Struct implements IBMessage {
    public final long time;

    public CurrentTime(long time) {
        this.time = time;
    }
}
