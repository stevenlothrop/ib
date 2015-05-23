package com.stevenlothrop.ib.commands;

import com.ib.client.EClientSocket;
import com.stevenlothrop.util.Struct;

public class EDisconnect extends Struct implements IBCommand{

    @Override
    public void accept(EClientSocket eClientSocket) {
        eClientSocket.eDisconnect();
    }
}
