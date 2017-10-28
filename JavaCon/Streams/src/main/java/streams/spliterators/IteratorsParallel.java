/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
