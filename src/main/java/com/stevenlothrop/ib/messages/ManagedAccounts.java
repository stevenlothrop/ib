package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class ManagedAccounts extends Struct implements IBMessage {
    public final String accountsList;

    public ManagedAccounts(String accountsList) {
        this.accountsList = accountsList;
    }
}
