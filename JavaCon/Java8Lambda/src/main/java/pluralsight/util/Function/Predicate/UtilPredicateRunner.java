package pluralsight.util.Function.Predicate;

import java.util.function.IntPredicate;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class UtilPredicateRunner {

	public static void main(String[] args) {
		java.util.function.Predicate<String> javaPredicate = s -> s.equals("Check it");
		java.util.function.Predicate<String> javaPredicate2 = s -> s.length() < 20;

		System.out.println(javaPredicate.negate());
		java.util.function.Predicate<String> negatedJavaPredicate = javaPredicate.negate();

		System.out.println(javaPredicate.test("Hi"));
		System.out.println(javaPredicate.and(javaPredicate2).test("Hi"));
		System.out.println(javaPredicate.or(javaPredicate2).test("Hi"));

		IntPredicate intPredicate = s -> s > 5;
	}
}
