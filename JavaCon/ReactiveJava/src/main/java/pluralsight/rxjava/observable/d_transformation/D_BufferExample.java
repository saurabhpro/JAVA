/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.d_transformation;

import pluralsight.rxjava.observable.util.ThreadUtils;
import pluralsight.rxjava.observable.util.TimeTicker;

import java.util.concurrent.TimeUnit;

public class D_BufferExample {

    public static void main(String[] args) {

        // Create a ticker that will go off 10 times per second (100ms)
        TimeTicker ticker = new TimeTicker(100);
        ticker.start();

        ticker.toObservable()
                // We want to buffer and emit once every second...
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(
                        // Each second, we will get a list of longs that were
                        // emitted.
                        (list) -> {
                            System.out.println("----------------------------");

                            // We will write things out in a way that we can
                            // see what it happening.
                            int count = 1;
                            int size = list.size();
                            for (Long aList : list) {
                                System.out.println("" + (count++) + ": " + aList);
                            }
                        }
                );

        // Do this for 5 seconds so we can see the effect.
        ThreadUtils.sleep(5000);

        // Stop the ticker.
        ticker.stop();

        System.exit(0);
    }

}
