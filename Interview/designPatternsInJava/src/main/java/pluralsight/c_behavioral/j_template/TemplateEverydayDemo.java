/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.c_behavioral.j_template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemplateEverydayDemo {

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

		Collections.sort(people);

		System.out.println("\nSorted by age");
		printContents(people);
	}
}
