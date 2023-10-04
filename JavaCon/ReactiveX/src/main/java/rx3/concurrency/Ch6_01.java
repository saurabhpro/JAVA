package rx3.concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

public class Ch6_01 {
    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM:ss");
        System.out.println(LocalDateTime.now().format(f));
        Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> LocalDateTime.now().format(f) + " " +
                          i + " Mississippi")
                .subscribe(System.out::println);
        sleep(5000);

        nonConcurrentObservables();
        concurrentObservables();
        executorObservables();
    }

    private static void executorObservables() {
        int numberOfThreads = 20;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        Scheduler scheduler = Schedulers.from(executor);
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown)
                .subscribe(System.out::println);
    }

    /**
     * using the subscribeOn() operator, which suggests to the source to
     * fire emissions on a specified Scheduler (separate thread). In this case, let's use
     * Schedulers.computation(), which pools a fixed number of threads appropriate for
     * computation operations. It will provide a thread to push emissions for each Observer.
     * When onComplete() is called, the thread will be given back to Scheduler so it can be
     * reused elsewhere
     */
    private static void concurrentObservables() {
        Observable.just("Alpha", "Beta", "Gamma")
                .subscribeOn(Schedulers.computation())
                .map(Ch6_01::intenseCalculation)
                .subscribe(System.out::println);

        Observable.range(1, 3)
                .subscribeOn(Schedulers.computation())
                .map(Ch6_01::intenseCalculation)
                .subscribe(System.out::println);
        sleep(20000);
    }

    /**
     * note how the first Observable firing Alpha, Beta,
     * and Gamma must finish first and call onComplete() before firing the second Observable
     * emitting the numbers 1 through 3.
     */
    private static void nonConcurrentObservables() {
        Observable.just("Alpha", "Beta", "Gamma")
                .map(Ch6_01::intenseCalculation)
                .subscribe(System.out::println);

        Observable.range(1, 3)
                .map(Ch6_01::intenseCalculation)
                .subscribe(System.out::println);
    }


    private static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }
}