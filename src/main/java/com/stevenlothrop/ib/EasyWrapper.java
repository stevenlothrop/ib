package com.stevenlothrop.ib;

import com.ib.client.*;
import com.ib.client.ContractDetails;
import com.stevenlothrop.ib.messages.*;
import com.stevenlothrop.ib.messages.CommissionReport;
import com.stevenlothrop.ib.messages.MarketDataType;

public class EasyWrapper implements EWrapper {
    private Callback<IBMessage> ibMessageCallback;

    public EasyWrapper(Callback<IBMessage> ibMessageCallback) {
        this.ibMessageCallback = ibMessageCallback;
    }

    @Override
    public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
        ibMessageCallback.on(new TickPrice(tickerId, field, price, canAutoExecute));
    }

    @Override
    public void tickSize(int tickerId, int field, int size) {
        ibMessageCallback.on(new TickSize(tickerId, field, size));
    }

    @Override
    public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma, double vega, double theta, double undPrice) {
        ibMessageCallback.on(new TickOptionComputation(tickerId, field, impliedVol, delta, optPrice, pvDividend, gamma, vega, theta, undPrice));
    }

    @Override
    public void tickGeneric(int tickerId, int tickType, double value) {
        ibMessageCallback.on(new TickGeneric(tickerId, tickType, value));
    }

    @Override
    public void tickString(int tickerId, int tickType, String value) {
        ibMessageCallback.on(new TickString(tickerId, tickType, value));
    }

    @Override
    public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {
        ibMessageCallback.on(new TickEFP(tickerId, tickType, basisPoints, formattedBasisPoints, impliedFuture, holdDays, futureExpiry, dividendImpact, dividendsToExpiry));
    }

    @Override
    public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId, String whyHeld) {
        ibMessageCallback.on(new OrderStatus(orderId, status, filled, remaining, avgFillPrice, permId, parentId, lastFillPrice, clientId, whyHeld));
    }

    @Override
    public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
        ibMessageCallback.on(new OpenOrder(orderId, contract, order, orderState));
    }

    @Override
    public void openOrderEnd() {
        ibMessageCallback.on(new OpenOrderEnd());
    }

    @Override
    public void updateAccountValue(String key, String value, String currency, String accountName) {
        ibMessageCallback.on(new UpdateAccountValue(key, value, currency, accountName));
    }

    @Override
    public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
        ibMessageCallback.on(new UpdatePortfolio(contract, position, marketPrice, marketValue, averageCost, unrealizedPNL, realizedPNL, accountName));
    }

    @Override
    public void updateAccountTime(String timeStamp) {
        ibMessageCallback.on(new UpdateAccountTime(timeStamp));
    }

    @Override
    public void accountDownloadEnd(String accountName) {
        ibMessageCallback.on(new AccountDownloadEnd(accountName));
    }

    @Override
    public void nextValidId(int orderId) {
        ibMessageCallback.on(new NextValidId(orderId));
    }

    @Override
    public void contractDetails(int reqId, ContractDetails contractDetails) {
        ibMessageCallback.on(new com.stevenlothrop.ib.messages.ContractDetails(reqId, contractDetails));
    }

    @Override
    public void bondContractDetails(int reqId, ContractDetails contractDetails) {
        ibMessageCallback.on(new BondContractDetails(reqId, contractDetails));
    }

    @Override
    public void contractDetailsEnd(int reqId) {
        ibMessageCallback.on(new ContractDetailsEnd(reqId));

    }

    @Override
    public void execDetails(int reqId, Contract contract, Execution execution) {
        ibMessageCallback.on(new ExecDetails(reqId, contract, execution));
    }

    @Override
    public void execDetailsEnd(int reqId) {
        ibMessageCallback.on(new ExecDetailsEnd(reqId));
    }

    @Override
    public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
        ibMessageCallback.on(new UpdateMktDepth(tickerId, position, operation, side, price, size));
    }

    @Override
    public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price, int size) {
        ibMessageCallback.on(new UpdateMktDepthL2(tickerId, position, marketMaker, operation, side, price, size));
    }

    @Override
    public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
        ibMessageCallback.on(new UpdateNewsBulletin(msgId, msgType, message, origExchange));
    }

    @Override
    public void managedAccounts(String accountsList) {
        ibMessageCallback.on(new ManagedAccounts(accountsList));
    }

    @Override
    public void receiveFA(int faDataType, String xml) {
        ibMessageCallback.on(new ReceiveFA(faDataType, xml));
    }

    @Override
    public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double WAP, boolean hasGaps) {
        ibMessageCallback.on(new HistoricalData(reqId, date, open, high, low, close, volume, count, WAP, hasGaps));
    }

    @Override
    public void scannerParameters(String xml) {
        ibMessageCallback.on(new ScannerParameters(xml));
    }

    @Override
    public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr) {
        ibMessageCallback.on(new ScannerData(reqId, rank, contractDetails, distance, benchmark, projection, legsStr));
    }

    @Override
    public void scannerDataEnd(int reqId) {
        ibMessageCallback.on(new ScannerDataEnd(reqId));
    }

    @Override
    public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {
        ibMessageCallback.on(new RealtimeBar(reqId, time, open, high, low, close, volume, wap, count));
    }

    @Override
    public void currentTime(long time) {
        ibMessageCallback.on(new CurrentTime(time));
    }

    @Override
    public void fundamentalData(int reqId, String data) {
        ibMessageCallback.on(new FundamentalData(reqId, data));
    }

    @Override
    public void deltaNeutralValidation(int reqId, UnderComp underComp) {
        ibMessageCallback.on(new DeltaNeutralValidation(reqId, underComp));
    }

    @Override
    public void tickSnapshotEnd(int reqId) {
        ibMessageCallback.on(new TickSnapshotEnd(reqId));
    }

    @Override
    public void marketDataType(int reqId, int marketDataType) {
        ibMessageCallback.on(new MarketDataType(reqId, marketDataType));
    }

    @Override
    public void commissionReport(com.ib.client.CommissionReport commissionReport) {
        ibMessageCallback.on(new CommissionReport(commissionReport));
    }

    @Override
    public void position(String account, Contract contract, int pos, double avgCost) {
        ibMessageCallback.on(new Position(account, contract, pos, avgCost));
    }

    @Override
    public void positionEnd() {
        ibMessageCallback.on(new PositionEnd());
    }

    @Override
    public void accountSummary(int reqId, String account, String tag, String value, String currency) {
        ibMessageCallback.on(new AccountSummary(reqId, account, tag, value, currency));
    }

    @Override
    public void accountSummaryEnd(int reqId) {
        ibMessageCallback.on(new AccountSummaryEnd());
    }

    @Override
    public void verifyMessageAPI(String apiData) {
        ibMessageCallback.on(new VerifyMessageAPI(apiData));

    }

    @Override
    public void verifyCompleted(boolean isSuccessful, String errorText) {
        ibMessageCallback.on(new VerifyCompleted(isSuccessful, errorText));
    }

    @Override
    public void displayGroupList(int reqId, String groups) {
        ibMessageCallback.on(new DisplayGroupList(reqId, groups));
    }

    @Override
    public void displayGroupUpdated(int reqId, String contractInfo) {
        ibMessageCallback.on(new DisplayGroupUpdated(reqId, contractInfo));
    }

    @Override
    public void error(Exception e) {
        ibMessageCallback.on(new ErrorWithException(e));
    }

    @Override
    public void error(String str) {
        ibMessageCallback.on(new ErrorWithString(str));
    }

    @Override
    public void error(int id, int errorCode, String errorMsg) {
        ibMessageCallback.on(new ErrorWithCode(id, errorCode, errorMsg));
    }

    @Override
    public void connectionClosed() {
        ibMessageCallback.on(new ConnectionClosed());
    }
}
