/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.e_conditional;

import pluralsight.rxjava.observable.util.DataGenerator;
import pluralsight.rxjava.observable.util.ThreadUtils;
import pluralsight.rxjava.observable.util.TimeTicker;
import pluralsight.rxjava.observable.util.TimedEventSequence;

public class F_TimedConditionalExampleTakeUntil {

	public static void main(String[] args) {

		// "takeUntil" example - Take the emissions of the greek alphabet
		// until the timer goes off in 3 seconds...
		TimedEventSequence<String> sequence1 = new TimedEventSequence<>(DataGenerator.generateGreekAlphabet(), 50);
		TimeTicker ticker = new TimeTicker(3000);

		// Create a takeUntil observable from the two sequences
		sequence1.toObservable()
				.takeUntil(ticker.toObservable())   // stops as soon as ticker emits
				.subscribe(System.out::println);    // take until

		// Start the driver thread for each of these sequences.
		ticker.start();
		sequence1.start();

		// Wait for 6 seconds while things run...we should see
		// output until 3 seconds have passed.
		ThreadUtils.sleep(6000);

		System.out.println("6 seconds elapsed.");

		// Stop each sequence.
		sequence1.stop();
		ticker.stop();

		System.exit(0);
	}

}
