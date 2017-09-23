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

import apress.util.function.Gender;
import apress.util.function.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saurabhkumar on 22/05/17.
 */
public class MapUtils {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(5, "A");
		map.put(6, "B");
		map.put(7, "C");

		//forEach (BiConsumer)
		map.forEach((a, b) -> System.out.println(a + "-> " + b));

		System.out.println(map.get(8));
		//new version of get method
		System.out.println(map.getOrDefault(8, "DefaultV"));

		System.out.println(map.putIfAbsent(8, "Yayee Unique"));


		map.replace(7, "P");
		map.replace(7, "P", "X");


		map.remove(8, "Yayee");
		map.remove(8);


		Person john = new Person("H", "C", LocalDate.now(), Gender.MALE);
		Map<String, Map<String, Person>> hashMap = new HashMap<>();
		hashMap.computeIfAbsent("one", key -> new HashMap<>()).put("two", john);
		hashMap.computeIfAbsent("one", key -> new HashMap<>()).put("one", john);

		hashMap.forEach((a, b) -> System.out.println(a + " : " + b));

		Map<String, List<Person>> listMap = new HashMap<>();
		listMap.computeIfAbsent("one", key -> new ArrayList<>()).add(john);

	}
}
