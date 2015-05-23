package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class VerifyMessageAPI extends Struct implements IBMessage {
    public final String apiData;

    public VerifyMessageAPI(String apiData) {
        this.apiData = apiData;
    }
}
