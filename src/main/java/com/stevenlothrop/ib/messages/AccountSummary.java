package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class AccountSummary extends Struct implements IBMessage {
    public final int reqId;
    public final String account;
    public final String tag;
    public final String value;
    public final String currency;

    public AccountSummary(int reqId, String account, String tag, String value, String currency) {
        this.reqId = reqId;
        this.account = account;
        this.tag = tag;
        this.value = value;
        this.currency = currency;
    }
}
