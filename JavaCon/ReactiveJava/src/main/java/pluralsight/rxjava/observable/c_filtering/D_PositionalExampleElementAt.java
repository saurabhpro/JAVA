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

/**
 * when we know where elements at
 */
public class D_PositionalExampleElementAt {

	public static void main(String[] args) {

		// Emit the 3rd letter in the greek alphabet
		// Gamma
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.elementAt(2)
				.subscribe((letter) -> {
					System.out.println(letter);
				});

		System.out.println();

		// Emit the 50th letter in the greek alphabet
		// ...there isn't a 50th letter, so we want to get "Unknown"
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.elementAt(50, "Unknown")
				.subscribe((letter) -> {
					System.out.println(letter);
				});

		System.out.println();


		System.exit(0);
	}
}