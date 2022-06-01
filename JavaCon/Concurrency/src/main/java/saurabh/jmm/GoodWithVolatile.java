package saurabh.jmm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class GoodWithVolatile {

    private volatile int counter = 0;

    public static void main(String[] args) {
        action();
    }

    private static void action() {
        var object = new GoodWithVolatile();
        ExecutorService executor = Executors.newCachedThreadPool();

        IntStream.rangeClosed(1, 5).boxed().forEach(v -> {
            executor.submit(() -> object.write(v));
            executor.submit(() -> object.read(v));
        });

        executor.shutdownNow();

        /* One Sample output - the idea is if v1 read = 6, read = 6, read immediately reads from the shared cache
         * Thread 2.2: 2
            Thread 1.4: 4
            Thread 2.4: 4
            Thread 1.2: 2
            Thread 2.1: 1
            Thread 2.3: 3
            Thread 1.1: 1
            Thread 1.3: 3
            Thread 1.5: 5
            Thread 2.5: 5
         */
    }

    void read(int version) {
        System.out.println("Thread 1." + version + ": " + counter);
    }

    void write(int version) {
        counter++;

        System.out.println("Thread 2." + version + ": " + counter);
    }
}
