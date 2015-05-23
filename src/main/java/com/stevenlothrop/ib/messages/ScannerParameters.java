package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ScannerParameters extends Struct implements IBMessage {
    public final String xml;

    public ScannerParameters(String xml) {
        this.xml = xml;
    }
}
