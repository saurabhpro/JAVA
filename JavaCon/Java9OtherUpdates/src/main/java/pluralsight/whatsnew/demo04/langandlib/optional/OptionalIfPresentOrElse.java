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

public class OptionalIfPresentOrElse {

	public static void main(String... args) {
		Optional<Book> full = Optional.of(Book.getBook());

		// Before ifPresentOrElse
		full.ifPresent(System.out::println);

		if (full.isPresent()) {
			System.out.println(full.get());
		} else {
			System.out.println("Nothing here");
		}

		full.ifPresentOrElse(System.out::println,
				() -> System.out.println("Nothing here!"));
		Optional.empty().ifPresentOrElse(System.out::println,
				() -> System.out.println("Nothing here!"));

	}

}
