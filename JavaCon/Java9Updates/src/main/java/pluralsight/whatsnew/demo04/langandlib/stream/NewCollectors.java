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

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class NewCollectors {
	public static void main(String... args) {
		Stream<Book> books = Book.getBooks();

		// Collect all books costing more than 10, grouped by author(s)
		Map<Set<String>, Set<Book>> booksByAuthors =
				books.collect(
						groupingBy(Book::getAuthors,
								filtering(b -> b.getPrice() > 10,
										toSet())
						)
				);
		System.out.println(booksByAuthors);

		books = Book.getBooks();
		// Collect all authors that sell books at a given price
		Map<Double, Set<String>> authorsSellingForPrice =
				books.collect(
						groupingBy(Book::getPrice,
								flatMapping(b -> b.getAuthors().stream(),
										toSet())
						)
				);
		System.out.println(authorsSellingForPrice);
	}
}
