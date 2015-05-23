package com.stevenlothrop.ib.messages;

import com.ib.client.Contract;
import com.stevenlothrop.util.Struct;

public class UpdatePortfolio extends Struct implements IBMessage {
    public final Contract contract;
    public final int position;
    public final double marketPrice;
    public final double marketValue;
    public final double averageCost;
    public final double unrealizedPNL;
    public final double realizedPNL;
    public final String accountName;

    public UpdatePortfolio(Contract contract, int position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
        this.contract = contract;
        this.position = position;
        this.marketPrice = marketPrice;
        this.marketValue = marketValue;
        this.averageCost = averageCost;
        this.unrealizedPNL = unrealizedPNL;
        this.realizedPNL = realizedPNL;
        this.accountName = accountName;
    }
}
