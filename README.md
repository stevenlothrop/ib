Main problem is the market data source.
IB will not provide a delayed market data feed or historical data for free.

How to use this library
- Download and run IB Gateway with your IB account.
- Run this app to connect with it.


Current info to show the usage of the library
- Connected to the target VM, address: '127.0.0.1:61441', transport: 'socket'
- EConnect{host='127.0.0.1', port=4001, clientId=1}
- Server Version:76
- TWS Time at connection:20150523 03:17:58 Greenwich Mean Time
- ManagedAccounts{accountsList='XXXXXXXX'}
- NextValidId{orderId=1}
- ErrorWithCode{id=-1, errorCode=2104, errorMsg='Market data farm connection is OK:usfarm'}
- ReqContractDetails{reqId=1000002, contract=com.ib.contracts.StkContract@4bb23d9b}
- ErrorWithCode{id=-1, errorCode=2107, errorMsg='HMDS data farm connection is inactive but should be available upon demand.ushmds'}
- ContractDetails{reqId=1000002, contractDetails=com.ib.client.ContractDetails@5dfd90ca}
- ReqHistoricalData{tickerId=1, contract=com.ib.client.Contract@680f3db9, endDateTime='20150522 00:00:00', durationStr='1 D', barSizeSetting='5 mins', whatToShow='TRADES', useRTH=0, formatDate=1, chartOptions=null}
- ContractDetailsEnd{reqId=1000002}
- ErrorWithCode{id=1, errorCode=354, errorMsg='Requested market data is not subscribed.'}
