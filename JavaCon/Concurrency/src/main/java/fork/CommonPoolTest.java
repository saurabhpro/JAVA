package fork;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * Two major concepts use the commonPool inside JDK: CompletableFuture and  Parallel Streams.
 * There is one small difference between those two features: with  CompletableFuture, you are able to specify your own thread-pool and don't use the threads from the commonPool, you cannot in case of  Parallel Streams.
 * <p>
 * Why shouldn't we use commonPool in all our cases? Don't we create an overhead when we create an additional thread-pool?
 * Yes, we definitely do, The key thing to remember in a decision process over whether to use commonPool or not is the purpose of our task, which is passed to the thread-pool.
 * In general, there are two types of tasks: computational and blocking.
 * <p>
 * In the case of a computational task, we create a task that absolutely avoids any blocking such as I/O operation
 * (database invocation, synchronization, thread sleep, etc...). The trick is that it does not matter on which thread your task is running,
 * you keep your CPU busy and don't wait for any resources. Then, feel free to use commonPool to execute your work.
 * <p>
 * However, if you intend to use commonPool for blocking tasks, then you need to consider some consequences.
 * If you have more than three available CPUs, then your commonPool is automatically sized to two threads and you can very easily block execution of any other part of your system that uses the commonPool at the same time by keeping the threads in a blocked state.
 * As a rule of thumb, we can create our own thread-pool for blocking tasks and keep the rest of the system separated and predictable.
 */
public class CommonPoolTest {

    public static void main(String[] args) {
        System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        var start = System.nanoTime();
        var futures = IntStream.range(0, 100)
            .mapToObj(i -> CompletableFuture.runAsync(CommonPoolTest::blockingOperation))
            .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        System.out.println("Processed in " + Duration.ofNanos(System.nanoTime() - start).toSeconds() + " sec");
    }

    private static void blockingOperation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}