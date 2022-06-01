package saurabh.atomic;

import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ThreadSafeCounterIntegrationTest {

    @RepeatedTest(5)
    void givenMultiThread_whenSafeCounterWithLockIncrement() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SafeCounterWithLock safeCounter = new SafeCounterWithLock();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(safeCounter::increment));
        final boolean b = service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertFalse(b);
        assertEquals(1000, safeCounter.getValue());
    }

    @RepeatedTest(5)
    void givenMultiThread_whenSafeCounterWithoutLockIncrement() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SafeCounterWithoutLock safeCounter = new SafeCounterWithoutLock();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(safeCounter::increment));
        final boolean b = service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertFalse(b);
        assertEquals(1000, safeCounter.getValue());
    }

    @RepeatedTest(5)
    void givenMultiThread_whenSafeCounterIncrement() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SafeCounterWithoutLock safeCounter = new SafeCounterWithoutLock();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(safeCounter::incrementSimple));
        final boolean b = service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertFalse(b);
        assertEquals(1000, safeCounter.getValue());
    }

}