/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.e_conditional;

import pluralsight.rxjava.observable.util.DataGenerator;
import pluralsight.rxjava.observable.util.ThreadUtils;
import pluralsight.rxjava.observable.util.TimeTicker;
import pluralsight.rxjava.observable.util.TimedEventSequence;

public class E_TimedConditionalExampleSkipUntil {

    public static void main(String[] args) {

        // "skipUntil" example - Skip the emissions of the greek alphabet
        // until the timer goes off in 3 seconds...
        TimedEventSequence<String> sequence1 = new TimedEventSequence<>(DataGenerator.generateGreekAlphabet(), 50);
        TimeTicker ticker = new TimeTicker(3000); // 3 secs

        // Create a skipUntil operation around the two sequences
        sequence1.toObservable()
                .skipUntil(ticker.toObservable())   // ticker begins to emit ticks
                .subscribe(System.out::println);    // characters

        // Start the driver thread for each of these sequences.
        ticker.start();
        sequence1.start();

        // Wait for 6 seconds while things run...we should not see any
        // output until 3 seconds have passed.
        ThreadUtils.sleep(6000);

        // Stop each sequence.
        sequence1.stop();
        ticker.stop();

        System.exit(0);
    }

}
