package saurabh.countdownlatch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;


class WaitingWorkerTest {
    private List<String> outputScraper;

    @BeforeEach
    void setup() {
        outputScraper = Collections.synchronizedList(new ArrayList<>());
    }

    @RepeatedTest(2)
    void whenParallelProcessing_thenMainThreadWillBlockUntilCompletion() throws InterruptedException {
        // Given
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> workers = Stream.generate(() -> new Thread(new Worker(outputScraper, countDownLatch)))
                .limit(5)
                .collect(toList());

        // When
        workers.forEach(Thread::start);
        countDownLatch.await(); // Block until workers finish
        outputScraper.add("Latch released");

        // Then
        assertThat(outputScraper).containsExactly("Counted down",
                "Counted down",
                "Counted down",
                "Counted down",
                "Counted down",
                "Latch released");
    }


    @RepeatedTest(2)
    void whenFailingToParallelProcess_thenMainThreadShouldTimeout() throws InterruptedException {
        // Given
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        final List<Thread> workers = Stream.generate(() -> new Thread(new BrokenWorker(outputScraper, countDownLatch)))
                .limit(5)
                .collect(toList());

        // When
        workers.forEach(Thread::start);
        final boolean result = countDownLatch.await(3L, TimeUnit.SECONDS);

        // Then
        assertThat(result).isFalse();
    }

    @RepeatedTest(2)
    void whenDoingLotsOfThreadsInParallel_thenStartThemAtTheSameTime() throws InterruptedException {
        // Given
        final CountDownLatch readyThreadCounter = new CountDownLatch(5);
        final CountDownLatch callingThreadBlocker = new CountDownLatch(1);
        final CountDownLatch completedThreadCounter = new CountDownLatch(5);

        final List<Thread> workers = Stream.generate(
                () -> new Thread(new WaitingWorker(outputScraper,
                        readyThreadCounter,
                        callingThreadBlocker,
                        completedThreadCounter)))
                .limit(5)
                .collect(toList());

        // When
        workers.forEach(Thread::start);

        readyThreadCounter.await(); // Block until workers start
        outputScraper.add("Workers ready");

        callingThreadBlocker.countDown(); // Start workers

        completedThreadCounter.await(); // Block until workers finish
        outputScraper.add("Workers complete");  // all latches have reached 0

        // Then
        assertThat(outputScraper).containsExactly("Workers ready",
                "Counted down",
                "Counted down",
                "Counted down",
                "Counted down",
                "Counted down",
                "Workers complete");

        assertThat(readyThreadCounter.getCount())
                .isZero();
        assertThat(callingThreadBlocker.getCount())
                .isZero();
        assertThat(completedThreadCounter.getCount())
                .isZero();
    }

}