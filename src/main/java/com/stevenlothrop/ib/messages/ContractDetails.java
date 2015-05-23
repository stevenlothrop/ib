package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ContractDetails extends Struct implements IBMessage {
    public final int reqId;
    public final com.ib.client.ContractDetails contractDetails;

    public ContractDetails(int reqId, com.ib.client.ContractDetails contractDetails) {
        this.reqId = reqId;
        this.contractDetails = contractDetails;
    }
}
