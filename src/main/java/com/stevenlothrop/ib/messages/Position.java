package com.stevenlothrop.ib.messages;

import com.ib.client.Contract;
import com.stevenlothrop.util.Struct;

public class Position extends Struct implements IBMessage {
    public final String account;
    public final Contract contract;
    public final int pos;
    public final double avgCost;

    public Position(String account, Contract contract, int pos, double avgCost) {
        this.account = account;
        this.contract = contract;
        this.pos = pos;
        this.avgCost = avgCost;
    }
}
