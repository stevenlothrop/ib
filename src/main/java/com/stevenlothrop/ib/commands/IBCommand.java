package com.stevenlothrop.ib.commands;

import com.ib.client.EClientSocket;

public interface IBCommand {
    void accept(EClientSocket eClientSocket);
}
