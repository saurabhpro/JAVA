/*
 * Copyright 2017 Saurabh Kumar 29/10/17 1:14 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.c_filtering;


import pluralsight.rxjava.observable.util.ThreadUtils;
import pluralsight.rxjava.observable.util.TimeTicker;

import java.util.concurrent.TimeUnit;

public class G_TimeBasedExampleTimeout {

	public static void main(String[] args) {

		// TimeTicker is a class that generates an event every
		// 100 milliseonds.  The event is a Long that represents
		// the current value of System.currentTimeMillis()
		TimeTicker ticker = new TimeTicker(100);
		ticker.start();

		try {
			// First, we get the observable event stream from the
			// ticker.
			ticker.toObservable()

					// We will timeout if the ticker stops for more than 3 seconds...
					// an onError will be generated
					.timeout(3, TimeUnit.SECONDS)
					.subscribe(
							// onNext
							(t) -> {
								// Every second, we will emit the current value
								// of System.currentTimeMillis()
								System.out.println("Tick: " + t);
							},
							// onError
							(exception) -> {
								System.out.println("TIMEOUT!");
								exception.printStackTrace();
							}
					);

			// Let it run for 1 seconds...it'll be spammy because the ticker
			// is in 100ms increments.
			ThreadUtils.sleep(1000);

			// ...then pause the ticker
			System.out.println("Pausing ticker.");
			ticker.pause();     // if timeout occured be notified

			// Wait another 5 seconds.  3 seconds to timeout and then another
			// 2 seconds for good measure.
			ThreadUtils.sleep(5000);
		} finally {
			// ...and then stop the ticker...which will also call
			// onCompleted() on all observers.
			ticker.stop();
		}
		System.exit(0);

	}
}
