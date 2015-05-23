package com.stevenlothrop.ib.messages;

import com.ib.client.ContractDetails;
import com.stevenlothrop.util.Struct;

public class BondContractDetails extends Struct implements IBMessage {
    public final int reqId;
    public final ContractDetails contractDetails;

    public BondContractDetails(int reqId, ContractDetails contractDetails) {
        this.reqId = reqId;
        this.contractDetails = contractDetails;
    }
}
