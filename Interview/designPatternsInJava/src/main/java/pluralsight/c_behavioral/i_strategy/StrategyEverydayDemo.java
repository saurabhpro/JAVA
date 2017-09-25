/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.c_behavioral.i_strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StrategyEverydayDemo {

	private static void printContents(List<Person> people) {
		for (Person person : people) {
			System.out.println(person.getName());
		}
	}

	public static void main(String args[]) {
		Person bryan = new Person("Bryan", "801-555-1212", 39);
		Person mark = new Person("Mark", "801-444-1234", 41);
		Person chris = new Person("Chris", "801-222-5151", 38);

		List<Person> people = new ArrayList<>();
		people.add(bryan);
		people.add(mark);
		people.add(chris);

		System.out.println("Not sorted");
		printContents(people);

		/*
		Collections.sort(people, new Comparator<>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getAge() > o2.getAge()) {
					return 1;
				}

				if (o1.getAge() < o2.getAge()) {
					return -1;
				}

				return 0;
			}
		});

		//to
		Collections.sort(people, (o1, o2) -> {
			if (o1.getAge() > o2.getAge()) {
				return 1;
			}

			if (o1.getAge() < o2.getAge()) {
				return -1;
			}

			return 0;
		});

		//to
		Collections.sort(people, (o1, o2) -> {
			return Integer.compare(o1.getAge(), o2.getAge());

		});

		people.sort((o1, o2) -> { return Integer.compare(o1.getAge(), o2.getAge()); });
		*/

		people.sort(Comparator.comparingInt(Person::getAge));

		System.out.println("\nSorted by age");
		printContents(people);

		//noinspection Convert2Lambda
		people.sort(new Comparator<>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		System.out.println("\nSorted by name");
		printContents(people);

	}
}
