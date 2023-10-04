package rx3.operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;

/**
 * Here we've 3 Do/Action operators to show how we can handle specific block stream, before it reaches
 * <p>
 */

public class Ob3DoOn {
    public static final Logger LOG = LoggerFactory.getLogger(Ob3DoOn.class);


    public static void main(String[] args) {
        exDoOnSubscribe();
        exDoOnNext();
        exDoOnComplete();

        exDoFinally();
        exDoOnDispose();
    }

    /**
     * doOnSubscribe will get the disposable as soon as we subscribe the specific observable
     */
    private static void exDoOnSubscribe() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5)
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: Subscribed"))
                .subscribe(System.out::println);
    }

    /**
     * doOnNext will get the item just before it reaches to the downstream of onNext
     */
    private static void exDoOnNext() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5)
                .doOnNext(item -> System.out.println("doOnNext: " + ++item))
                .subscribe(System.out::println);
    }

    /**
     * doOnComplete will get void just before it reaches to the downstream of onComplete
     */
    private static void exDoOnComplete() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5)
                .doOnComplete(() -> System.out.println("doOnComplete: Completed"))
                .subscribe(System.out::println, System.out::print, () -> System.out.println("Completed"));
    }


    /**
     * doFinally works after the observable is done or onComplete
     */
    private static void exDoFinally() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5)
                .doFinally(() -> System.out.println("doFinally: Completed"))
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed usual"));
    }

    /**
     * doOnDispose only works if we can dispose the observable explicitly
     * before onComplete or onError
     */
    private static void exDoOnDispose() {
        LOG.info(LINE);
        final Disposable subscribe = Observable.just(1, 2, 3, 4, 5)
                .doOnDispose(() -> System.out.println("onDispose: Disposed"))
                .subscribe(System.out::println);

        subscribe.dispose();    // nothing happens as dispose is already done as the printing ended


        LOG.info(LINE);

        // the order is subscribed is called -> the on dispose method is defined - the do on subscribe is called and
        // disposed
        Observable.just(1, 2, 3, 4, 5)
                .doOnDispose(() -> System.out.println("onDispose: Disposed"))
                .doOnSubscribe(Disposable::dispose)
                .subscribe(System.out::println);

        // so the order if say onSubscribe then onDispose -> we won't see anything

    }
}