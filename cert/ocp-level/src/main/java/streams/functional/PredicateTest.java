package streams.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {

		Predicate<String> nullCheck = arg -> arg != null;
		Predicate<String> emptyCheck = arg -> arg.length() > 0;
		Predicate<String> nullAndEmptyCheck = nullCheck.and(emptyCheck);
		String helloStr = "hello";
		System.out.println(nullAndEmptyCheck.test(helloStr));
		String nullStr = null;
		System.out.println(nullAndEmptyCheck.test(nullStr));


		BiPredicate<List<Integer>, Integer> listContains = List::contains;
		List<Integer> aList = Arrays.asList(10, 20, 30);
		System.out.println(listContains.test(aList, 20)); // returns boolean not Boolean
	}
}

class RemoveIfMethod {
	public static void main(String[] args) {
		List<String> greeting = new ArrayList<>();
		greeting.add("hello");
		greeting.add("world");
		greeting.removeIf(str -> !str.startsWith("h"));
		greeting.forEach(System.out::println);

		greeting.removeIf(((Predicate<String>) str -> str.startsWith("h")).negate());

		//Without this explicit type cast–as in ((str -> str.startsWith("h")).negate())
		// –the compiler cannot perform type inference to determine the matching functional interface
		// and hence will report an error
	}
}
