package com.stevenlothrop.ib.commands;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.stevenlothrop.util.Struct;

public class ReqContractDetails extends Struct implements IBCommand {
    public final int reqId;
    public final Contract contract;

    public ReqContractDetails(int reqId, Contract contract) {
        this.reqId = reqId;
        this.contract = contract;
    }

    @Override
    public void accept(EClientSocket eClientSocket) {
        eClientSocket.reqContractDetails(reqId, contract);
    }
}
