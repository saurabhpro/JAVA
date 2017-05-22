package pluralsight.Predicate;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class CustomPredicateRunner {
	public static void main(String[] args) {

		//old ways of writing anonymous class
		Predicate<Integer> predicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				return integer > 20;
			}
		};

		System.out.println(predicate.test(45));


		//new way of implementing abstract method of functional interface
		Predicate<String> stringPredicate = s -> s.length() > 20;

		System.out.println(stringPredicate.test("Helloo"));
	}


}
