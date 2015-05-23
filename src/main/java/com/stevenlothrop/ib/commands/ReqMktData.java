package com.stevenlothrop.ib.commands;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.TagValue;
import com.stevenlothrop.util.Struct;

import java.util.List;

public class ReqMktData extends Struct implements IBCommand {
    public final int tickerId;
    public final Contract contract;
    public final String genericTickList;
    public final boolean snapshot;
    public final List<TagValue> mktDataOptions;

    public ReqMktData(int tickerId, Contract contract, String genericTickList, boolean snapshot, List<TagValue> mktDataOptions) {
        this.tickerId = tickerId;
        this.contract = contract;
        this.genericTickList = genericTickList;
        this.snapshot = snapshot;
        this.mktDataOptions = mktDataOptions;
    }

    @Override
    public void accept(EClientSocket eClientSocket) {
        eClientSocket.reqMktData(tickerId, contract, genericTickList, snapshot, mktDataOptions);
    }
}
