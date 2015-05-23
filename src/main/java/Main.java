import com.ib.client.EClientSocket;
import com.stevenlothrop.MarketDataSubscriber;
import com.stevenlothrop.concurrent.Channel;
import com.stevenlothrop.concurrent.EasyThread;
import com.stevenlothrop.concurrent.EasyThreads;
import com.stevenlothrop.ib.EasyWrapper;
import com.stevenlothrop.ib.commands.EConnect;
import com.stevenlothrop.ib.commands.IBCommand;
import com.stevenlothrop.ib.messages.IBMessage;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static class Channels{
        public static Channel<IBCommand> ibCommands = new Channel<>();
        public static Channel<IBMessage> ibMessage = new Channel<>();
    }
    public static void main(String[] args) throws InterruptedException {
        EasyThreads easyThreads = new EasyThreads();

        // Interactive Brokers
        {
            EasyThread thread = easyThreads.createAndSoutExceptions();
            EClientSocket eClientSocket = new EClientSocket(new EasyWrapper(Channels.ibMessage::publish));
            thread.subscribe(Channels.ibCommands, ibCommand -> {
                System.out.println(ibCommand);
                ibCommand.accept(eClientSocket);
            });
        }
        // Driver
        {
            EasyThread thread = easyThreads.createAndSoutExceptions();
            thread.execute(() -> Channels.ibCommands.publish(new EConnect("127.0.0.1", 4001, 1)));
            thread.subscribe(Channels.ibMessage, System.out::println);
            MarketDataSubscriber marketDataSubscriber = new MarketDataSubscriber(Channels.ibCommands);
            thread.subscribe(Channels.ibMessage, ibMessage -> marketDataSubscriber.on(ibMessage));
        }
        easyThreads.start();
        new CountDownLatch(1).await();
    }
}
