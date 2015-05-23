package com.stevenlothrop;

import com.ib.client.Contract;
import com.ib.client.TagValue;
import com.ib.contracts.StkContract;
import com.stevenlothrop.concurrent.Publisher;
import com.stevenlothrop.ib.commands.IBCommand;
import com.stevenlothrop.ib.commands.ReqContractDetails;
import com.stevenlothrop.ib.commands.ReqHistoricalData;
import com.stevenlothrop.ib.messages.ContractDetails;
import com.stevenlothrop.ib.messages.IBMessage;
import com.stevenlothrop.ib.messages.ManagedAccounts;
import com.stevenlothrop.ib.messages.NextValidId;
import com.stevenlothrop.util.Sequence;

import java.util.List;

public class MarketDataSubscriber {
    private final Sequence tickerId = new Sequence(0);
    private Sequence reqId = null;
    private final Publisher<IBCommand> ibCommandPublisher;

    public MarketDataSubscriber(Publisher<IBCommand> ibCommandPublisher) {
        this.ibCommandPublisher = ibCommandPublisher;
    }

    public void on(IBMessage ibMessage) {
        if(ibMessage instanceof NextValidId){
            reqId = new Sequence(((NextValidId) ibMessage).orderId + 1000000);
            Contract contract = new StkContract("AAPL");
            ibCommandPublisher.publish(new ReqContractDetails(reqId.next(), contract));
        }
        if (ibMessage instanceof ManagedAccounts) {
        }
        if (ibMessage instanceof ContractDetails) {
            com.ib.client.ContractDetails contractDetails = ((ContractDetails) ibMessage).contractDetails;
            String endDateTime = "20150522 00:00:00";
            String durationStr = "1 D";
            String barSizeSetting = "5 mins";
            String whatToShow = "TRADES";
            int useRTH = 0;
            int formatDate = 1;
            List<TagValue> chartOptions = null;
            ibCommandPublisher.publish(new ReqHistoricalData(tickerId.next(), contractDetails.m_summary, endDateTime, durationStr, barSizeSetting, whatToShow, useRTH, formatDate, chartOptions));
//          ibCommandPublisher.publish(new ReqMktData(tickerId.next(), contractDetails.m_summary,null, true, null ));
        }
    }
}
