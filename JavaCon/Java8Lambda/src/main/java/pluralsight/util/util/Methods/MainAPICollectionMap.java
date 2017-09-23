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

import pluralsight.util.common.City;
import pluralsight.util.common.Person;

import java.util.*;

/**
 * @author José Paumard
 */
public class MainAPICollectionMap {

	public static void main(String[] args) {

		Person p1 = new Person("Alice", 23);
		Person p2 = new Person("Brian", 56);
		Person p3 = new Person("Chelsea", 46);
		Person p4 = new Person("David", 28);
		Person p5 = new Person("Erica", 37);
		Person p6 = new Person("Francisco", 18);

		City newYork = new City("New York");
		City shanghai = new City("Shanghai");
		City paris = new City("Paris");

		Map<City, List<Person>> map = new HashMap<>();

		map.putIfAbsent(paris, new ArrayList<>());
		map.get(paris).add(p1);

		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

		System.out.println("People from Paris : " + map.getOrDefault(paris, Collections.EMPTY_LIST));
		System.out.println("People from New York : " + map.getOrDefault(newYork, Collections.EMPTY_LIST));

		Map<City, List<Person>> map1 = new HashMap<>();
		map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

		System.out.println("Map 1");
		map1.forEach((city, people) -> System.out.println(city + " : " + people));


		Map<City, List<Person>> map2 = new HashMap<>();
		map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);

		System.out.println("Map 2");
		map2.forEach((city, people) -> System.out.println(city + " : " + people));

		map2.forEach(
				(city, people) ->
						map1.merge(
								city, people,
								(peopleFromMap1, peopleFromMap2) -> {
									peopleFromMap1.addAll(peopleFromMap2);
									return peopleFromMap1;
								}
						)
		);

		System.out.println("Merged map1 ");
		map1.forEach(
				(city, people) -> System.out.println(city + " : " + people)
		);
	}
}
