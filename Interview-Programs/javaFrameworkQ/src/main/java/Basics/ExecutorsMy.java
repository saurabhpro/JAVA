package Basics;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsMy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // Creates an Executor that uses a single worker thread operating off an // unbounded queue.
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();


        Future future = executorService1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("From executorService1");
            }
        });

        System.out.println(future.get()); // returns null if the task has finished correctly.


        // Creates a thread pool that reuses a fixed number of threads
        // operating off a shared unbounded queue. At any point, the parameter
        // specifies the most threads that will be active processing tasks.
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);


        // Creates a thread pool that can schedule commands to run after a
        // given delay, or to execute periodically.
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

    }
}
