package pluralsight.Function;


import pluralsight.common.Person;

/**
 * @author José Paumard
 */
public class MainComparator {

	public static void main(String... args) {

		Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
		Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

		java.util.function.Function<Person, String> nameMapper = p -> p.getFirstName();

		Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
		Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);
		//Comparator<Person> cmpPersonFirstName = Comparator.comparing(f3);


		Comparator<Person> cmp = Comparator.comparing(Person::getLastName)
				.thenComparing(Person::getFirstName)
				.thenComparing(Person::getAge);
	}
}
