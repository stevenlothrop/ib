package com.stevenlothrop.ib.messages;

import com.stevenlothrop.util.Struct;

public class TickOptionComputation extends Struct implements IBMessage {
    public final int tickerId;
    public final int field;
    public final double impliedVol;
    public final double delta;
    public final double optPrice;
    public final double pvDividend;
    public final double gamma;
    public final double vega;
    public final double theta;
    public final double undPrice;

    public TickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma, double vega, double theta, double undPrice) {
        this.tickerId = tickerId;
        this.field = field;
        this.impliedVol = impliedVol;
        this.delta = delta;
        this.optPrice = optPrice;
        this.pvDividend = pvDividend;
        this.gamma = gamma;
        this.vega = vega;
        this.theta = theta;
        this.undPrice = undPrice;
    }
}
