/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo04.langandlib.stream;

import java.util.stream.IntStream;

public class TakeDropWhile {

	public static void main(String... args) {

		// Before takeWhile
		IntStream.range(1, 100)
				.filter(i -> i < 4) // applied to all elements
				.forEach(System.out::println);

		// With takeWhile, only the first 4 elements are
		// evaluated against the predicate.
		IntStream.range(1, 100)
				.takeWhile(i -> i < 4) // short-circuits on element '4'
				.forEach(System.out::println);


		// Before dropWhile
		IntStream.range(1, 10)
				.filter(i -> i >= 4)
				.forEach(System.out::println);

		// With dropWhile (only works if Stream is sorted!)
		IntStream.range(1, 10)
				.dropWhile(i -> i < 4)
				.forEach(System.out::println);
	}

}
