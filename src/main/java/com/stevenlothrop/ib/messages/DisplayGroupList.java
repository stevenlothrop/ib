package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class DisplayGroupList extends Struct implements IBMessage {
    public final int reqId;
    public final String groups;

    public DisplayGroupList(int reqId, String groups) {
        this.reqId = reqId;
        this.groups = groups;
    }
}
