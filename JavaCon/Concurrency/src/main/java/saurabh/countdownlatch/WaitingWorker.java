package saurabh.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class WaitingWorker implements Runnable {

    private final List<String> outputScraper;
    private final CountDownLatch readyThreadCounter;
    private final CountDownLatch callingThreadBlocker;
    private final CountDownLatch completedThreadCounter;

    WaitingWorker(final List<String> outputScraper,
                  final CountDownLatch readyThreadCounter,
                  final CountDownLatch callingThreadBlocker,
                  CountDownLatch completedThreadCounter) {

        this.outputScraper = outputScraper;
        this.readyThreadCounter = readyThreadCounter;
        this.callingThreadBlocker = callingThreadBlocker;
        this.completedThreadCounter = completedThreadCounter;
    }

    @Override
    public void run() {
        // Mark this thread as read / started
        readyThreadCounter.countDown();
        try {
            // block until the other latch is realeased by triggering a countdown(1)
            callingThreadBlocker.await();

            //do the work
            System.out.println("Doing some logic " + Thread.currentThread().getName() + "-" + completedThreadCounter.getCount());
            outputScraper.add("Counted down");
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        } finally {
            // start decrementing each thread one by one
            completedThreadCounter.countDown();
        }
    }
}