package com.stevenlothrop.ib.messages;

import com.ib.client.ContractDetails;
import com.stevenlothrop.util.Struct;

public class ScannerData extends Struct implements IBMessage {
    public final int reqId;
    public final int rank;
    public final ContractDetails contractDetails;
    public final String distance;
    public final String benchmark;
    public final String projection;
    public final String legsStr;

    public ScannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr) {
        this.reqId = reqId;
        this.rank = rank;
        this.contractDetails = contractDetails;
        this.distance = distance;
        this.benchmark = benchmark;
        this.projection = projection;
        this.legsStr = legsStr;
    }
}
