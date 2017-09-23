/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package methodReference.staticEx;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Created by saurabhkumar on 23/05/17.
 */
public class AnExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

		// Using an anonymous class
		//noinspection Convert2Lambda
		NumbersO.findNumbers(list, new BiPredicate<>() {
			public boolean test(Integer i1, Integer i2) {
				return NumbersO.isMoreThanFifty(i1, i2);
			}
		});

		// Using a lambda expression
		NumbersO.findNumbers(list, (i1, i2) -> NumbersO.isMoreThanFifty(i1, i2));

		// Using a method reference
		NumbersO.findNumbers(list, NumbersO::isMoreThanFifty);
	}
}
