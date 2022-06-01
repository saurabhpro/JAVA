package saurabh.atomic;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ThreadUnsafeCounterManualTest {

    @Disabled("This test shows the behaviour of a thread-unsafe class in a multi-threaded scenario. We are calling" +
            " the increment methods 1000 times from a pool of 3 threads. In most of the cases, the counter will" +
            " less than 1000, because of lost updates, however, occasionally it may reach 1000, when no threads" +
            " called the method simultaneously. This may cause the build to fail occasionally. Hence excluding this" +
            " test from build by adding this in manual test")
    @RepeatedTest(5)
    void givenMultiThread_whenUnsafeCounterIncrement() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        UnsafeCounter unsafeCounter = new UnsafeCounter();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(unsafeCounter::increment));
        final boolean b = service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertFalse(b);
        assertEquals(1000, unsafeCounter.getValue());
    }

}