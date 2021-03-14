package saurabh.jmm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class GoodWithSynchronized {

    private int counter = 0;

    public static void main(String[] args) {
        action();
    }

    private static void action() {
        var object = new GoodWithSynchronized();
        ExecutorService executor = Executors.newCachedThreadPool();


        IntStream.rangeClosed(1, 5).boxed().forEach(v -> {
            executor.submit(() -> object.write(v));
            executor.submit(() -> object.read(v));
        });

        executor.shutdownNow();

        /* One Sample output - the idea is if one thread read = 6, next thread read immediately from the shared cache
         * Thread 2.1: 1
            Thread 1.5: 1
            Thread 2.5: 2
            Thread 1.4: 2
            Thread 2.4: 3
            Thread 1.3: 3
            Thread 2.3: 4
            Thread 1.2: 4
            Thread 2.2: 5
            Thread 1.1: 5
         */
    }

    synchronized void read(int version) {
        System.out.println("Thread 1." + version + ": " + counter);
    }

    void write(int version) {
        synchronized (this) {
            counter++;
            System.out.println("Thread 2." + version + ": " + counter);
        }
    }
}
