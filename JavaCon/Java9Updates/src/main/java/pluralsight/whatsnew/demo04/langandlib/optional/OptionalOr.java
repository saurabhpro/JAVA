/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo04.langandlib.optional;

import pluralsight.whatsnew.demo04.langandlib.Book;

import java.util.Optional;
import java.util.Set;

public class OptionalOr {
	public static void main(String... args) {
		Optional<Book> localFallback = Optional.of(Book.getBook());

		// Before Optional.or
		Book bestBookBefore = getBestOffer()
				.orElse(getExternalOffer().orElse(localFallback.get()));  // .get() is BAD!

		Optional<Book> bestBook =
				getBestOffer()
						.or(() -> getExternalOffer())
						.or(() -> localFallback);
		System.out.println(bestBook);
	}

	static Optional<Book> getBestOffer() {
		return Optional.empty();
	}

	static Optional<Book> getExternalOffer() {
		return Optional.of(new Book("External Book", Set.of(), 11.99));
	}
}