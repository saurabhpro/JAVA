package rx3.basics;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.ResourceObserver;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;
import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;


/**
 * <p>
 * We've shown how to deal with Disposables in various ways
 * <p>
 */
public class Ob5Disposable {
    public static final Logger LOG = LoggerFactory.getLogger(Ob5Disposable.class);

    public static void main(String[] args) {
        handleDisposable();
        handleDisposableInObserver();
        handleDisposableOutsideObserver();
        compositeDisposable();
    }

    /**
     * Saves the returned disposable from the subscribe(),
     * and dispose it after 3000 milliseconds and pase the
     * thread for 3000 milliseconds more to check whether it emits or not
     */
    private static void handleDisposable() {
        LOG.info(LINE);
        var observable = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable = observable.subscribe(x -> LOG.info("{}", x));
        sleep(3000);
        disposable.dispose();      // once disposed nothing will be printed
        sleep(3000);
    }

    /**
     * When we pass an Observer to the subscribe() method, it returns void.
     * So we need to get the Disposable from the overridden method onSubscribe,
     * so we can deal with it anywhere and any point in time
     */
    private static void handleDisposableInObserver() {
        LOG.info(LINE);
        var observable = Observable.just(1, 2, 3, 4, 5);

        var observer = new Observer<Integer>() {
            private Disposable disposable;

            @Override
            public void onSubscribe(@NotNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NotNull Integer integer) {
                if (integer == 3) {
                    disposable.dispose();
                }

                LOG.info("{}", integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        // no disposable - you should pick it from onSubscribe
        observable.subscribe(observer);
    }

    /**
     * Used ResourceObserver here, to the disposable out of the subscribe
     * Instead of subscribe(), subscribeWith() has been used here
     * Which returns the Observer that we pass in
     * As ResourceObserver implements Disposable,
     * so we can deal with it like it is a Disposable
     */
    private static void handleDisposableOutsideObserver() {
        LOG.info(LINE);
        var observable = Observable.just(1, 2, 3, 4, 5);

        var observer = new ResourceObserver<Integer>() {

            @Override
            public void onNext(@NotNull Integer integer) {
                LOG.info("{}", integer);
            }

            @Override
            public void onError(@NotNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Disposable d = observable.subscribeWith(observer);
        d.dispose();
    }

    /**
     * Used CompositeDisposable and used it's add method
     * to add Disposables to the set of Disposables
     * by calling the dispose on CompositeDisposable instead of disposing each and everyone
     * We can even use the delete method to remove any disposable from the set of CompositeDisposable
     */
    private static void compositeDisposable() {
        LOG.info(LINE);
        CompositeDisposable compositeDisposable = new CompositeDisposable();

        var observable = Observable.interval(1, TimeUnit.SECONDS);

        // create two subscribers
        Disposable disposable1 = observable.subscribe(item -> LOG.info("Observer 1: {}", item));
        Disposable disposable2 = observable.subscribe(item -> LOG.info("Observer 2: {}", item));

        // add all disposables to composite
        compositeDisposable.addAll(disposable1, disposable2);

        sleep(3000);

        // compositeDisposable.delete(disposable1);
        compositeDisposable.dispose();

        sleep(3000);
    }
}
