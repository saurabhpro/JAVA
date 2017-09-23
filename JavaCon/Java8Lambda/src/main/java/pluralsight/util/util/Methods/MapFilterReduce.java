/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.util.util.Methods;

import pluralsight.util.common.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Created by saurabhkumar on 23/05/17.
 */
public class MapFilterReduce {
	private static int reduce(
			List<Integer> values,
			int valueIfEmpty,
			BinaryOperator<Integer> reduction) {

		int result = valueIfEmpty;
		for (int value : values) {
			result = reduction.apply(result, value);
		}
		return result;
	}

	public static void main(String[] args) {

		List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, -1, -2, -3, -4);

		List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
		List<Integer> ints2 = Arrays.asList(-1, -2, -3, -4);

		BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1, i2);

		int reduction1 = reduce(ints1, 0, op);
		int reduction2 = reduce(ints2, 0, op);
		int reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op);
		// int reduction = reduce(ints, 0, op);

		System.out.println("Reduction : " + reduction2);


		Person p1 = new Person("Alice", 23);
		Person p2 = new Person("Brian", 56);
		Person p3 = new Person("Chelsea", 46);
		Person p4 = new Person("David", 28);
		Person p5 = new Person("Erica", 37);
		Person p6 = new Person("Francisco", 18);

		List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));


		list.stream()                           //Stream<Person>
				.map(p -> p.getAge())          //Stream<Integer>
				.filter(p -> p > 30)            //Stream<Integer>
				.forEach(System.out::println);
		//map() will change the type of the stream, filter() doesnt


		list.stream()                           //Stream<Person>
				.map(p -> p.getAge())          //Stream<Integer>
				.peek(System.out::println)      //this works as non terminating and useful for logging, it it an intermediate operation, no printning yet
				.filter(p -> p > 30)            //Stream<Integer>
				.forEach(System.out::println);  //this actually process map data

		list.stream()                           //Stream<Person>
				.skip(2)
				.limit(3)
				.filter(p -> p.getAge() > 30)    //Stream<Integer>
				.forEach(System.out::println);  //triggers the processing

		//return true if all predicate returns true
		list.stream()
				.allMatch(p -> p.getAge() > 30);
		//.anyMatch(p -> p.getAge() > 30);
		//.noneMatch(p -> p.getAge() > 30);     //these are called short circuiting


		//both return any person but wrapped in Optional if stream is empty
		Optional<Person> optional = list.stream()
				.findFirst();
		//findAny()


		//list.stream().reduce(0, (p8, p9)-> p8.getAge()+ p9.getAge()); //since we gave identity = 0, returned result will be int

	}


}
