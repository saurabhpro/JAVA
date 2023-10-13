package rx3.operators;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

/**
 * Like any Subject, it can be used to observe and subscribe to the sources. In addition, it buffers
 * all the emissions it receives until an Observer subscribes to it, and then it releases all the
 * emissions to the Observer and clears its cache.
 */
public class Ob8Subject {
    public static void main(String[] args) {
        Subject<String> subject = UnicastSubject.create();

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1) * 300) + " milliseconds")
                .subscribe(subject);
        sleep(2000);

        //multicast to support multiple Observers
        Observable<String> multicast = subject.publish().autoConnect();

        //bring in first Observer
        multicast.subscribe(s -> System.out.println("Observer 1: " + s));
        sleep(2000);

        //bring in second Observer
        multicast.subscribe(s -> System.out.println("Observer 2: " + s));
        sleep(1000);
    }
}