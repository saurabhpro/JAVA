package pluralsight.util.Function.Function;

import java.util.function.IntFunction;

/**
 * Created by saurabhkumar on 22/05/17.
 */
public class UtilFunctionRunner {
	public static void main(String[] args) {
		java.util.function.Function<Integer, String> function = (integer -> "My number is " + integer);
		System.out.println(function.apply(56));


		java.util.function.BiFunction<Integer, Integer, String> function2 = (integer, flo) -> "My number is " + integer + " and " + flo;
		System.out.println(function2.apply(56, 67));


		//when all input output types are same, better use these below

		java.util.function.UnaryOperator<Integer> function3 = (integer -> integer * 4);
		System.out.println(function3.apply(56));


		java.util.function.BinaryOperator<Integer> function4 = (integer, flo) -> integer + flo;
		System.out.println(function4.apply(56, 67));


		IntFunction<String> intFunction = (a) -> "Hi";


	}
}
