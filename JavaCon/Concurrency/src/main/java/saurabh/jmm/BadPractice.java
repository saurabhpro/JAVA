package saurabh.jmm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BadPractice {

    private int counter = 0;

    public static void main(String[] args) {
        action();
    }

    private static void action() {
        var object = new BadPractice();
        ExecutorService executor = Executors.newCachedThreadPool();

        IntStream.rangeClosed(1, 5).boxed().forEach(v -> {
            executor.submit(() -> object.write(v));
            executor.submit(() -> object.read(v));
        });


        executor.shutdownNow();

        /* One Sample output
         * Thread 1.3: 0
            Thread 2.4: 0
            Thread 1.2: 0
            Thread 1.1: 0
            Thread 2.3: 0
            Thread 2.2: 0
            Thread 2.1: 0
            Thread 1.4: 4
            Thread 2.5: 4
            Thread 1.5: 4
         */
    }

    void read(int version) {
        System.out.println("Thread 1." + version + ": " + counter);
    }

    void write(int version) {
        System.out.println("Thread 2." + version + ": " + counter);
        counter++;
    }
}
