package pluralsight.util.Function.methodReference.staticEx;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static pluralsight.util.Function.methodReference.staticEx.NumbersO.findNumbers;

/**
 * Created by saurabhkumar on 23/05/17.
 */
public class AnExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

		// Using an anonymous class
		findNumbers(list, new BiPredicate<Integer, Integer>() {
			public boolean test(Integer i1, Integer i2) {
				return NumbersO.isMoreThanFifty(i1, i2);
			}
		});

		// Using a lambda expression
		findNumbers(list, (i1, i2) -> NumbersO.isMoreThanFifty(i1, i2));

		// Using a method reference
		findNumbers(list, NumbersO::isMoreThanFifty);
	}
}
