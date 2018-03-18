/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.collectors;

import streams.model.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class CollectorPartitioningBy {
	public static void main(String[] args) {

		final Person donDraper = new Person("Don", "Draper", 89);
		final Person peggyOlson = new Person("Peggy ", "Olson", 75);
		final Person bertCooper = new Person("Bert ", "Cooper", 100);


		Predicate<Person> isOld = person -> person.getAge() > 80;
		System.out.println(isOld.test(donDraper));
		System.out.println(isOld.test(peggyOlson));


		List<Person> people = Arrays.asList(donDraper, peggyOlson, bertCooper);

		final Map<Boolean, List<Person>> result = people.stream()
				.collect(partitioningBy(person -> person.getAge() > 80));

		System.out.println(result);

		//the target type defines if the right side has proper type usage in lambda
		final Map<Boolean, Long> result2 = people.stream()
				.collect(partitioningBy(person -> person.getAge() > 80, counting()));

		/*
		 * counting()
		 *
		 * Returns a {Collector} accepting elements of type T that
		 * counts the number of input elements.  If no elements are present, the
		 * result is 0.
		 */
		System.out.println(result2);

		/*
		 * partitioningBy(Predicate<..> predicate, Collector<..> downstream)
		 *
		 * Returns a Collector which partitions the input elements according
		 * to a Predicate, and organizes them into a {Map<Boolean, List<T>>}.
		 *
		 * The returned Map always contains mappings for both {false} and {true} keys.
		 * There are no guarantees on the type, mutability, serializability, or thread-safety of the {Map} or {List}
		 * returned.
		 *
		 * @apiNote
		 * If a partition has no elements, its value in the result Map will be
		 * an empty List.
		 */


		// Accumulate names into a TreeSet
		Set<String> set = people.stream()
				.map(Person::getFirstName)
				.collect(Collectors.toCollection(TreeSet::new)); //similarly toList()

		set.forEach(System.out::println);

		// Convert elements to strings and concatenate them, separated by commas
		String joined = people.stream()
				.map(Object::toString)
				.collect(Collectors.joining(", "));
	}
}
