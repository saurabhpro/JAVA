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

import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class B_PositionalExampleFirstAndLast {

	public static void main(String[] args) {

		// Emit the greek alphabet, but only the first letter
		// Alpha
		System.out.println("Get First: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.first("Default if empty")  //first now take a mandatory item for default
				.subscribe(System.out::println);

		System.out.println();

		// Emit the greek alphabet, but only the first 4
		// Alpha, Beta, Gamma, Delta
		System.out.println("Get First 4: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.take(4)
				.subscribe(System.out::println);

		System.out.println();

		// Emit the greek alphabet, but only the last letter
		// Omega
		System.out.println("Get Last: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.last("Default if empty")   // last needs a default to be passed now
				.subscribe(System.out::println);

		System.out.println();

		// Emit the greek alphabet, but this time only the last 4
		// Phi, Chi, Psi, Omeaga
		System.out.println("Get Last 4: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.takeLast(4)
				.subscribe(System.out::println);

		System.out.println();

		// firstOrDefault and lastOrDefault allows you to handle the case where there is
		// an empty list.
		Observable.empty()
				.first("List is empty!")
				.subscribe(System.out::println);

		Observable.empty()
				.last("List is empty!")
				.subscribe(System.out::println);

		System.exit(0);
	}
}
