package com.stevenlothrop.ib.messages;

import com.ib.client.Contract;
import com.ib.client.Execution;
import com.stevenlothrop.util.Struct;

public class ExecDetails extends Struct implements IBMessage {
    public final int reqId;
    public final Contract contract;
    public final Execution execution;

    public ExecDetails(int reqId, Contract contract, Execution execution) {
        this.reqId = reqId;
        this.contract = contract;
        this.execution = execution;
    }
}
