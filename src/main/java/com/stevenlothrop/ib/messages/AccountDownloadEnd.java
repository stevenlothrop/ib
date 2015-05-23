package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class AccountDownloadEnd extends Struct implements IBMessage  {
    public final String accountName;

    public AccountDownloadEnd(String accountName) {
        this.accountName = accountName;
    }
}
