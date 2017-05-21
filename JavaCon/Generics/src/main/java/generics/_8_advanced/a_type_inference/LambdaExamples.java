package generics._8_advanced.a_type_inference;

import generics._8_advanced.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class LambdaExamples {
	public static void main(String[] args) {
		final Person donDraper = new Person("Don Draper", 89);
		final Person peggyOlson = new Person("Peggy Olson", 75);
		final Person bertCooper = new Person("Bert Cooper", 100);


		Predicate<Person> isOld = person -> person.getAge() > 80;
		System.out.println(isOld.test(donDraper));
		System.out.println(isOld.test(peggyOlson));

		List<Person> people = new ArrayList<>();
		people.add(donDraper);
		people.add(peggyOlson);
		people.add(bertCooper);

		final Map<Boolean, List<Person>> result = people
				.stream()
				.collect(partitioningBy(person -> person.getAge() > 80));

		System.out.println(result);

		//the target type defines if the right side has proper type usage in lambda
		final Map<Boolean, Long> result2 = people
				.stream()
				.collect(partitioningBy(person -> person.getAge() > 80, counting()));

		System.out.println(result2);


	}
}
