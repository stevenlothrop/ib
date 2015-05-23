package com.stevenlothrop.ib.commands;

import com.ib.client.EClientSocket;
import com.stevenlothrop.util.Struct;

public class CancelMktData extends Struct implements IBCommand{
    public final int tickerId;

    public CancelMktData(int tickerId) {
        this.tickerId = tickerId;
    }

    @Override
    public void accept(EClientSocket eClientSocket) {
        eClientSocket.cancelMktData(tickerId);
    }
}
