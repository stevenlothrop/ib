package com.stevenlothrop.ib.commands;

import com.ib.client.EClientSocket;
import com.stevenlothrop.util.Struct;

public class EConnect extends Struct implements IBCommand {
    public final String host;
    public final int port;
    public final int clientId;

    public EConnect(String host, int port, int clientId) {
        this.host = host;
        this.port = port;
        this.clientId = clientId;
    }

    @Override
    public void accept(EClientSocket eClientSocket) {
        eClientSocket.eConnect(host, port, clientId);
    }
}
