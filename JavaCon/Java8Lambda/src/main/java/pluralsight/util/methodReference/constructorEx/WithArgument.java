package pluralsight.util.methodReference.constructorEx;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by saurabhkumar on 23/05/17.
 */
public class WithArgument {
	public static void main(String[] args) {

		// Using an anonymous class
		Function<String, Integer> f =
				new Function<String, Integer>() {
					public Integer apply(String s) {
						return new Integer(s);
					}
				};
		Integer i1 = f.apply("100");


		// Using a lambda expression
		Function<String, Integer> f2 = s -> new Integer(s);
		Integer i2 = f2.apply("100");


		// Using a method reference
		Function<String, Integer> f3 = Integer::new;
		Integer i3 = f3.apply("100");


		// Using a anonymous class
		BiFunction<String, String, Locale> f4 = new BiFunction<String, String, Locale>() {
			public Locale apply(String lang, String country) {
				return new Locale(lang, country);
			}
		};
		Locale loc1 = f4.apply("en", "UK");

		// Using a lambda expression
		BiFunction<String, String, Locale> f5 = (lang, country) -> new Locale(lang, country);
		Locale loc2 = f5.apply("en", "UK");

		// Using a method reference
		BiFunction<String, String, Locale> f6 = Locale::new;
		Locale loc3 = f6.apply("en", "UK");
	}
}
