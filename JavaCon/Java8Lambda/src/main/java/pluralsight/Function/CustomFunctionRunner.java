package pluralsight.Function;

import pluralsight.common.Person;

/**
 * Created by saurabhkumar on 22/05/17.
 */
public class CustomFunctionRunner {
	public static void main(String[] args) {
		Function<Person, Integer> f1 = p -> p.getAge();
		Function<Person, String> f2 = p -> p.getLastName();
		Function<Person, String> f3 = p -> p.getFirstName();

		System.out.println(f1.apply(new Person("H", "C", 45)));
		System.out.println(f2.apply(new Person("H", "C", 45)));
		System.out.println(f3.apply(new Person("H", "C", 45)));
	}
}
