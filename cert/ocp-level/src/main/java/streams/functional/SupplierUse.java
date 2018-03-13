package streams.functional;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * a Supplier<T> “supplies” takes nothing but returns something:
 * it has no arguments and returns an object (of generic type T).
 * You can call get() method on a Supplier object.
 */
public class SupplierUse {
	public static void main(String[] args) {
		Random random = new Random();
		Supplier<Boolean> booleanSupplier = random::nextBoolean;

		Stream.generate(booleanSupplier)
				.limit(2)
				.forEach(System.out::println);

		// The lambda expression does not take any output but returns the current date/time as a String format.
		Supplier<String> currentDateTime = () -> LocalDateTime.now().toString();
		System.out.println(currentDateTime.get());


		Supplier<String> newString = String::new;
		System.out.println(newString.get());

		//the constructor Integer(String):
		// this Integer constructor takes a String as an argument and creates
		// an Integer object with the value given in that string
		Function<String, Integer> anotherInteger = Integer::new;
		System.out.println(anotherInteger.apply("100"));
	}
}