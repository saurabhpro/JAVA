/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo04.langandlib;

import java.util.Set;
import java.util.stream.Stream;

public class Book {

	public final String title;
	public final Set<String> authors;
	public final double price;

	public Book(String title, Set<String> authors, double price) {
		this.title = title;
		this.authors = authors;
		this.price = price;
	}

	public static Stream<Book> getBooks() {
		return Stream.of(new Book("Java 9 Modularity", Set.of("Sander Mak", "Paul Bakker"), 33.99),
				new Book("Designing Data-Intensive Applications", Set.of("Martin Klepmann"), 38.99),
				new Book("Java 8 Lambdas", Set.of("Richard Warburton"), 33.99));
	}

	public static Book getBook() {
		return getBooks().findFirst().get();
	}

	public String getTitle() {
		return title;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book{" +
				"title='" + title + '\'' +
				", price=" + price +
				'}';
	}
}
