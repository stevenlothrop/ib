package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class CommissionReport extends Struct implements IBMessage {
    public final com.ib.client.CommissionReport commissionReport;

    public CommissionReport(com.ib.client.CommissionReport commissionReport) {
        this.commissionReport = commissionReport;
    }
}
