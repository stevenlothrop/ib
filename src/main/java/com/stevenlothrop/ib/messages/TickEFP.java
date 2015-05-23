package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class TickEFP extends Struct implements IBMessage {
    public final int tickerId;
    public final int tickType;
    public final double basisPoints;
    public final String formattedBasisPoints;
    public final double impliedFuture;
    public final int holdDays;
    public final String futureExpiry;
    public final double dividendImpact;
    public final double dividendsToExpiry;

    public TickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {
        this.tickerId = tickerId;
        this.tickType = tickType;
        this.basisPoints = basisPoints;
        this.formattedBasisPoints = formattedBasisPoints;
        this.impliedFuture = impliedFuture;
        this.holdDays = holdDays;
        this.futureExpiry = futureExpiry;
        this.dividendImpact = dividendImpact;
        this.dividendsToExpiry = dividendsToExpiry;
    }
}
