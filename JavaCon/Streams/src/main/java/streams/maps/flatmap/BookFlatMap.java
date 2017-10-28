/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package streams.maps.flatmap;

import streams.maps.flatmap.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookFlatMap {

	/*
	The flatmap() method is a special kind of map() which allows to flatten nested structures or avoid ending up with them.
	 */
	public static void main(String[] args) {

		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");
		obj2.addBook("Effective Javascript");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);

		//stream to collect both students unique book names
		@SuppressWarnings("Convert2MethodRef") List<String> bookNames = list.stream()
				.map(x -> x.getBook())      //Stream<Set<String>>
				.flatMap(x -> x.stream())   //Stream<String>
				.distinct()
				.sorted()
				.collect(Collectors.toList());

		//noinspection Convert2MethodRef
		bookNames.forEach(x -> System.out.println(x));
	}

}