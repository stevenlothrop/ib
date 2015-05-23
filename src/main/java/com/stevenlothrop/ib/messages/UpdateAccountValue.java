package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class UpdateAccountValue extends Struct implements IBMessage {
    public final String key;
    public final String value;
    public final String currency;
    public final String accountName;

    public UpdateAccountValue(String key, String value, String currency, String accountName) {
        this.key = key;
        this.value = value;
        this.currency = currency;
        this.accountName = accountName;
    }
}
