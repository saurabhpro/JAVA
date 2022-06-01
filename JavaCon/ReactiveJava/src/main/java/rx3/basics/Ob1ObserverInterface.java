package rx3.basics;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * We've created the Observer interface so we can pass it to the subscribe method
 * and do the required task on onNext(), onError() and onComplete() overridden method
 * onNext() method emits the item available on the Observable source, one by one
 * onError() method throws an error if something goes wrong while the emission
 * onComplete() method let us know if the emission ends
 * N.B. We don't get the onComplete() callback if we ever get to the onError()
 * <p>
 */
public class Ob1ObserverInterface {
    private static final Logger LOG = LoggerFactory.getLogger(Ob1ObserverInterface.class);

    public static void main(String[] args) {
        // which generates the observable items to emit - cannot take null
        var observable = Observable.just(1, 2, 3, 4, 5);

        var observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                LOG.info("Got {}", integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LOG.error(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                LOG.info("Completed");
            }
        };

        // subscribe can also take an observer
        observable.subscribe(observer);
    }
}