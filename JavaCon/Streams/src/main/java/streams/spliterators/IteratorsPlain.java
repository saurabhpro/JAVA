/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.spliterators;

import streams.model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorsPlain {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();

		// Add some people using Person objects
		people.add(new Person("Jane", "Doe", "Ireland"));
		people.add(new Person("Joe", "Doe", "England"));
		people.add(new Person("John", "Doe", "Scotland"));
		people.add(new Person("Julie", "Doe", "Wales"));
		people.add(new Person("Jerry", "Doe", "France"));
		people.add(new Person("Jim", "Doe", "Italy"));

		// simple iterator example
		Iterator<Person> peopleIterator = people.iterator();

		//noinspection WhileLoopReplaceableByForEach
		while (peopleIterator.hasNext()) {
			Person person = peopleIterator.next();
			System.out.println("Hello " + person.getFirstName() +
					" " + person.getLastName() +
					" from " + person.getCountry());
		}
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
