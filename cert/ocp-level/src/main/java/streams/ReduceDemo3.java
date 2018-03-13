package streams;

import java.util.Arrays;
import java.util.List;

// Stream.reduce() with Accumulator
class ReduceDemo1 {
	public static void main(String[] args) {
		int[] array = {23, 43, 56, 97, 32};
		Arrays.stream(array)
				.reduce((x, y) -> x + y)
				.ifPresent(System.out::println);

		Arrays.stream(array)
				.parallel()
				.reduce(Integer::sum)
				.ifPresent(System.out::println);
	}
}

// Stream.reduce() with Identity, Accumulator and Combiner
// only beneficial if the stream is parallel() -
public class ReduceDemo3 {
	public static void main(String[] args) {
		List<Integer> list2 = Arrays.asList(2, 3, 4);

		//Here result will be 2*2 + 2*3 + 2*4 that is 18.
		int res = list2.parallelStream()
				.reduce(2, (s1, s2) -> s1 * s2, (p, q) -> p + q);
		System.out.println(res);


		List<String> list1 = Arrays.asList("Mohan", "Sohan", "Ramesh");

		// (- + Mohan) + (- + Sohan) + (- + Ramesh)
		String result = list1.parallelStream()
				.reduce("-", (s1, s2) -> s1 + s2, (p, q) -> p + q);
		System.out.println(result);
	}
}

// Stream.reduce() with Accumulator
class ReduceToString {
	public static void main(String[] args) {
		//Reduce Array to String.
		String[] array = {"Mohan", "Sohan", "Mahesh"};
		Arrays.stream(array)
				.reduce((x, y) -> x + "," + y)
				.ifPresent(s -> System.out.println("Array to String: " + s));

		//Reduce List to String.
		List<String> list = Arrays.asList("Mohan", "Sohan", "Mahesh");
		list.stream()
				.reduce((x, y) -> x + "," + y)
				.ifPresent(s -> System.out.println("List to String: " + s));
	}
}


// Stream.reduce() with Identity, Accumulator
class ReduceToSum {
	public static void main(String[] args) {
		//Reduce Array to sum.
		int[] array = {30, 10, 20, 40};
		int sum = Arrays.stream(array).reduce(0, (x, y) -> x + y);
		System.out.println("Sum of Array: " + sum);
		//Reduce List to sum.
		List<Integer> list = Arrays.asList(30, 10, 20, 40);
		sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Sum of List: " + sum);
	}
}