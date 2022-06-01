package saurabh.locks;

import java.util.concurrent.Callable;

public record ReentrantLockCounterCallable(ReentrantLockCounter counter) implements Callable<Integer> {

    @Override
    public Integer call() {
        counter.incrementCounter();
        return counter.getCounter();
    }
}