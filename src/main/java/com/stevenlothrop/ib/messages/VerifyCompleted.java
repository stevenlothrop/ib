package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class VerifyCompleted extends Struct implements IBMessage {
    public final boolean isSuccessful;
    public final String errorText;

    public VerifyCompleted(boolean isSuccessful, String errorText) {
        this.isSuccessful = isSuccessful;
        this.errorText = errorText;
    }
}
