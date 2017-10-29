/*
 * Copyright 2017 Saurabh Kumar 29/10/17 3:07 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
