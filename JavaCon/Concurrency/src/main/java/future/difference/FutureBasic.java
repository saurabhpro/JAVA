package future.difference;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ThreadNameFetcher implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        //return the thread name executing this callable task
        System.out.println("Thread fetcher call");

        return Thread.currentThread().getName();
    }
}

public class FutureBasic {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(4);
        var threadNameFetcher = new ThreadNameFetcher();
        //Placeholder or promise
        Future<String> future1 = executor.submit(threadNameFetcher);
        System.out.println("done: " + future1.isDone());

        String threadName = future1.get();
        System.out.println("Thread name " + threadName);
        executor.shutdown();
        System.out.println("done: " + future1.isDone());
    }
}