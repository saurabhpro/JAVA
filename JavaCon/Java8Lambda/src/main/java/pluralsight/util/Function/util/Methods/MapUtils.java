package pluralsight.util.Function.util.Methods;

import saurabh.java8.lambda.Apress.Gender;
import saurabh.java8.lambda.Apress.Person;

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
		hashMap.computeIfAbsent("one", key -> new HashMap<String, Person>()).put("two", john);
		hashMap.computeIfAbsent("one", key -> new HashMap<String, Person>()).put("one", john);

		hashMap.forEach((a, b) -> System.out.println(a + " : " + b));

		Map<String, List<Person>> listMap = new HashMap<>();
		listMap.computeIfAbsent("one", key -> new ArrayList<Person>()).add(john);

	}
}
