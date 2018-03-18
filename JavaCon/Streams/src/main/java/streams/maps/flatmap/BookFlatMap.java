/*
 * Copyright (c) 2018 Saurabh Kumar
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