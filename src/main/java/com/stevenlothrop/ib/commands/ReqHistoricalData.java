package com.stevenlothrop.ib.commands;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.TagValue;
import com.stevenlothrop.util.Struct;

import java.util.List;

public class ReqHistoricalData extends Struct implements IBCommand {
    public final int tickerId;
    public final Contract contract;
    public final String endDateTime;
    public final String durationStr;
    public final String barSizeSetting;
    public final String whatToShow;
    public final int useRTH;
    public final int formatDate;
    public final List<TagValue> chartOptions;

    public ReqHistoricalData(int tickerId, Contract contract, String endDateTime, String durationStr, String barSizeSetting, String whatToShow, int useRTH, int formatDate, List<TagValue> chartOptions) {
        this.tickerId = tickerId;
        this.contract = contract;
        this.endDateTime = endDateTime;
        this.durationStr = durationStr;
        this.barSizeSetting = barSizeSetting;
        this.whatToShow = whatToShow;
        this.useRTH = useRTH;
        this.formatDate = formatDate;
        this.chartOptions = chartOptions;
    }

    @Override
    public void accept(EClientSocket eClientSocket) {
        eClientSocket.reqHistoricalData(tickerId, contract, endDateTime, durationStr, barSizeSetting, whatToShow, useRTH, formatDate, chartOptions);
    }
}
