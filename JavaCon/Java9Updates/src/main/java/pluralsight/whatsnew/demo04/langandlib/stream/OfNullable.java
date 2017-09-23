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

import pluralsight.whatsnew.demo04.langandlib.Book;

import java.util.stream.Stream;

import static pluralsight.whatsnew.demo04.langandlib.Book.getBook;

public class OfNullable {

	public static void main(String... args) {

		long zero = Stream.ofNullable(null).count();
		long one = Stream.ofNullable(getBook()).count();

		System.out.printf("zero: %d, one: %d", zero, one);

		// Before ofNullable
		Book book = getPossiblyNull(true);
		Stream<String> authors =
				book == null ? Stream.empty() : book.authors.stream();
		authors.forEach(System.out::println);

		// With ofNullable
		Stream.ofNullable(getPossiblyNull(false))
				.flatMap(b -> b.authors.stream())
				.forEach(System.out::println);
	}

	private static Book getPossiblyNull(boolean isNull) {
		return isNull ? null : getBook();
	}


}
