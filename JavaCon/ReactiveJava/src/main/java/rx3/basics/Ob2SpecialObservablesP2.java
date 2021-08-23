package rx3.basics;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;

/**
 * We've created Single, Maybe and Completable
 * All of them works almost like Observable but with some functionality removed
 * <p>
 */

public class Ob2SpecialObservablesP2 {
    private static final Logger LOG = LoggerFactory.getLogger(Ob2SpecialObservablesP2.class);

    public static void main(String[] args) {
        createSingle();
        createMaybe();
        createCompletable();
    }

    /**
     * Creates a single and emit data to it's Observer only once
     */
    private static void createSingle() {
        LOG.info(LINE);
        Single.just("Hello World")
                .subscribe(x -> LOG.info("{}", x));
    }

    /**
     * Creates a Maybe, and it may or may not emit data to it's Observers
     * <p>Maybe.empty() has been called here and this factory method doesn't emit, only completes</p>
     */
    private static void createMaybe() {
        LOG.info(LINE);

        Maybe.empty().subscribe(new MaybeObserver<>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Object o) {
                LOG.info("{}", o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                LOG.info("Done");
            }
        });
    }

    /**
     * Creates a Completable
     * <p>
     * Completable.fromSingle() factory method has been used here which takes a single
     * But it doesn't emit any item to it's Observers
     * </p>
     * <p>
     * Because CompletableObserver doesn't have any onNext() method
     * And it's works is limited to let it's Observers know that something has been completed
     * You may be using this sometime just to test some stuff
     * Otherwise, this is not used much often in production
     * </p>
     */
    private static void createCompletable() {
        LOG.info(LINE);

        Completable.fromSingle(Single.just("Hello World"))
                .subscribe(() -> LOG.info("Done"));
    }
}