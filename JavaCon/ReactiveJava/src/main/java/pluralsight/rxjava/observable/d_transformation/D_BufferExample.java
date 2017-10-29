/*
 * Copyright 2017 Saurabh Kumar 29/10/17 6:42 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
