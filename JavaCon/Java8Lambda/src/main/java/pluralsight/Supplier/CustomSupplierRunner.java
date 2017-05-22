package pluralsight.Supplier;

import pluralsight.common.Person;

/**
 * Created by saurabhkumar on 22/05/17.
 */
public class CustomSupplierRunner {
	public static void main(String[] args) {
		Supplier<Integer> supplier = new Supplier<Integer>() {
			@Override
			public Integer get() {
				return 500;
			}
		};
		System.out.println(supplier.get());

		Supplier<String> stringSupplier = () -> "This is what you get";
		System.out.println(stringSupplier.get());


		Supplier<Person> personSupplier = () -> new Person();
		Supplier<Person> personSupplier2 = Person::new; //but for parameterized constructor, we cant do this
	}
}
