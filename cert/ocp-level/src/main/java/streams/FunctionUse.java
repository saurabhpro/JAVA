package streams;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntBiFunction;

/**
 * The Function interface defines a single abstract method named apply()
 * that takes an argument of generic type T
 * and returns an object of generic type R
 */
public class FunctionUse {
	public static void main(String[] args) {
		Arrays.stream("4, -9, 16".split(", "))
				.map(Integer::parseInt)
				.map(i -> (i < 0) ? -i : i)
				.forEach(System.out::println);


		Function<String, Integer> strLength = str /*input*/ -> str.length();  /*return*/
		System.out.println(strLength.apply("supercalifragilisticexpialidocious"));


		Function<String, Integer> parseInt = Integer::parseInt;
		Function<Integer, Integer> absInt = Math::abs;


		// The andThen() method applies the passed argument after calling the current Function.
		// return (T t) -> after.apply(apply(t)); // after is the passed argument in andThen(after)
		Function<String, Integer> parseAndAbsInt = parseInt.andThen(absInt);

		// The compose() method calls the argument before calling the current Function.
		// return (V v) -> apply(before.apply(v)) // // before is the passed argument in compose(before)
		Function<String, Integer> parseAndAbsIntC = absInt.compose(parseInt);


		Arrays.stream("4, -9, 16".split(", "))
				.map(parseAndAbsInt)
				.forEach(System.out::println);


		Function<Integer, Integer> absInt1 = Math::abs;
		// You can replace it with its equivalent using int specialization for Function, known as IntFunction:
		IntFunction absInt2 = Math::abs;


		BiFunction<String, String, String> concatStr = (x, y) -> x + y;
		System.out.println(concatStr.apply("hello ", "world"));

		// we used BiFunction<Double, Double, Integer>. Instead of that,
		BiFunction<Double, Double, Integer> compareDoubles = Double::compare;
		// we could use the functional interface ToIntBiFunction because it returns an int.
		ToIntBiFunction<Double, Double> compareDoubles1 = Double::compare;

		System.out.println(compareDoubles.apply(10.0, 10.0));
		System.out.println(compareDoubles1.applyAsInt(10.0, 10.0));
	}
}