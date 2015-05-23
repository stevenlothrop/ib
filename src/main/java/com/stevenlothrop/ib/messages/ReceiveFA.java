package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ReceiveFA extends Struct implements IBMessage {
    public final int faDataType;
    public final String xml;

    public ReceiveFA(int faDataType, String xml) {
        this.faDataType = faDataType;
        this.xml = xml;
    }
}
