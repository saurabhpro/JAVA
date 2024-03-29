/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package from.pluralsight.waitnotify;

import java.util.stream.IntStream;

public class ProducerConsumer {

    private static final Object lock = new Object();

    private static int[] stockBuffer;
    private static int count;

    private static boolean isEmpty(int[] stockBuffer) {
        return count == 0;
    }

    private static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static void main(String... strings) throws InterruptedException {

        stockBuffer = new int[10];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            IntStream.range(0, 50).forEach(i -> producer.produce());
            System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            IntStream.range(0, 100).forEach(i -> consumer.consume());
            System.out.println("Done consuming");
        };

        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("Data in the stockBuffer: " + count);
    }

    static class Producer {

        void produce() {
            synchronized (lock) {
                while (isFull(stockBuffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                stockBuffer[count++] = 1;
                lock.notify();
            }
        }
    }

    static class Consumer {

        void consume() {
            synchronized (lock) {
                while (isEmpty(stockBuffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                stockBuffer[--count] = 0;
                lock.notify();
            }
        }
    }
}
