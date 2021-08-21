package saurabh.locks;

import java.util.*;
import java.util.concurrent.*;

// https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java-concurrency-basic/src/main/java/com/baeldung/concurrent/threadsafety/application/Application.java
public class Application {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> System.out.println(MathUtils.factorial(10)));
        executorService.submit(() -> System.out.println(MathUtils.factorial(5)));

//        MessageService messageService = new MessageService("Welcome to Baeldung!");
//        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
//        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
//        System.out.println(future1.get());
//        System.out.println(future2.get());
//
//        Counter counter = new Counter();
//        Future<Integer> future3 = (Future<Integer>) executorService.submit(new CounterCallable(counter));
//        Future<Integer> future4 = (Future<Integer>) executorService.submit(new CounterCallable(counter));
//        System.out.println(future3.get());
//        System.out.println(future4.get());

//        ObjectLockCounter objectLockCounter = new ObjectLockCounter();
//        Future<Integer> future5 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(objectLockCounter));
//        Future<Integer> future6 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(objectLockCounter));
//        System.out.println(future5.get());
//        System.out.println(future6.get());

        System.out.println("ReentrantLockCounter");
        reentrant(executorService);

        System.out.println("ReentrantReadWriteLockCounter");
        readWriteLock(executorService);

//        AtomicCounter atomicCounter = new AtomicCounter();
//        Future<Integer> future11 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
//        Future<Integer> future12 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
//        System.out.println(future11.get());
//        System.out.println(future12.get());

        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        executorService.submit(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        executorService.submit(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Map<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1", "one");
        concurrentMap.put("2", "two");
        concurrentMap.put("3", "three");

        executorService.shutdown();

        // all threads have successfully exited
        System.out.println(syncCollection);
    }

    private static void readWriteLock(ExecutorService executorService) throws InterruptedException, ExecutionException {
        ReentrantReadWriteLockCounter reentrantReadWriteLockCounter = new ReentrantReadWriteLockCounter();
        Future<Integer> future9 = executorService.submit(new ReentrantReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
        Future<Integer> future10 = executorService.submit(new ReentrantReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
        System.out.println(future9.get());
        System.out.println(future10.get());
    }

    private static void reentrant(ExecutorService executorService) throws InterruptedException, ExecutionException {
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();
        Future<Integer> future7 = executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
        Future<Integer> future8 = executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
        System.out.println(future7.get());
        System.out.println(future8.get());
    }
}