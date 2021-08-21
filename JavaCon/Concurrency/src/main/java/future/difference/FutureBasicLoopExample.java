package future.difference;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

class EmailSender implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("In Email Sender");

        return Thread.currentThread().getName() + " email sent";
    }
}

class OrderEnricher implements Callable<String> {

    public OrderEnricher(String test) {

    }

    @Override
    public String call() throws Exception {
        // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("In Order Enricher");

        return Thread.currentThread().getName() + " order enriched";
    }

}

class OrderFetcher implements Callable<String> {

    @Override
    public String call() throws Exception {
        // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("In Order Fetcher");
        sleep(200);
        return Thread.currentThread().getName() + " order fetched";
    }

}

class PaymentAccepter implements Callable<String> {

    @Override
    public String call() throws Exception {
        // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("In Payment Accepter");

        return Thread.currentThread().getName() + " payment accepted";
    }

}

//Timer
//Change number of threads

public class FutureBasicLoopExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(4);
        //int numberoforders = 1;
        Instant start = Instant.now();
        for (int numberoforders = 1; numberoforders <= 3; numberoforders++) {
            var orderFetcher = new OrderFetcher();
            var orderEnricher = new OrderEnricher("test");
            var paymentAccepter = new PaymentAccepter();
            var emailSender = new EmailSender();

            //Placeholder or promise
            Future<String> future1 = executor.submit(orderFetcher);
            Future<String> future2 = executor.submit(orderEnricher);
            Future<String> future3 = executor.submit(paymentAccepter);
            Future<String> future4 = executor.submit(emailSender);

            //Dependency Injection


            String order = future1.get();
            System.out.println("Order number #" + numberoforders + " Thread name " + order);
            //Future<String> future2 = executor.submit(orderEnricher);
            order = future2.get();
            System.out.println("Order number #" + numberoforders + " Thread name " + order);
            order = future3.get();
            System.out.println("Order number #" + numberoforders + " Thread name " + order);
            order = future4.get();
            System.out.println("Order number #" + numberoforders + " Thread name " + order);
        }

        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Total time " + timeElapsed + "ms");
        executor.shutdown();
    }

}