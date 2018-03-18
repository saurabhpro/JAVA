/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.spliterators;

import streams.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class IteratorsParallel {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();

		// Add some people using Person objects
		people.add(new Person("Jane", "Doe", "Ireland"));
		people.add(new Person("Joe", "Doe", "England"));
		people.add(new Person("John", "Doe", "Scotland"));
		people.add(new Person("Julie", "Doe", "Wales"));
		people.add(new Person("Jerry", "Doe", "France"));
		people.add(new Person("Jim", "Doe", "Italy"));

		Spliterator<Person> peopleSpliterator = people.spliterator();
		System.out.println(" " + peopleSpliterator.characteristics());
		System.out.println(" " + peopleSpliterator.estimateSize());

		Spliterator<Person> newPartition = peopleSpliterator.trySplit();
		System.out.println(" " + newPartition.estimateSize());
		System.out.println(" " + peopleSpliterator.estimateSize()); // leaving the existing Spliterator with a reduced number of elements in its own partition.
	}
}

/*
Hello Jane Doe from Ireland
Hello Joe Doe from England
Hello John Doe from Scotland
Hello Julie Doe from Wales
Hello Jerry Doe from France
Hello Jim Doe from Italy
*/
