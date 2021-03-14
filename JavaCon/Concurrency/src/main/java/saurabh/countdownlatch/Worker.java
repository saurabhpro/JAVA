package saurabh.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    private final List<String> outputScraper;
    private final CountDownLatch countDownLatch;

    Worker(final List<String> outputScraper, final CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        // Do some work
        System.out.println("Doing some logic " + Thread.currentThread().getName() + "-" + countDownLatch.getCount());
        outputScraper.add("Counted down");

        // decrement the thread counter
        countDownLatch.countDown();
    }
}