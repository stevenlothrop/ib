package com.stevenlothrop.ib.messages;

import com.ib.client.UnderComp;
import com.stevenlothrop.util.Struct;

public class DeltaNeutralValidation extends Struct implements IBMessage {
    public final int reqId;
    public final UnderComp underComp;

    public DeltaNeutralValidation(int reqId, UnderComp underComp) {
        this.reqId = reqId;
        this.underComp = underComp;
    }
}
