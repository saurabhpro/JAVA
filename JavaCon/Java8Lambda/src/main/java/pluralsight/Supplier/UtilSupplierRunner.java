package pluralsight.Supplier;

import pluralsight.common.Person;

/**
 * Created by saurabhkumar on 22/05/17.
 */
public class UtilSupplierRunner {
	public static void main(String[] args) {
		java.util.function.Supplier<Person> personSupplier = () -> new Person("H", "C", 45);
		System.out.println(personSupplier.get());
	}
}
