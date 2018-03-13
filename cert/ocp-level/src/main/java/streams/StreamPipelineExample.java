package streams;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamPipelineExample {
	public static void main(String[] args) throws IOException {
		Arrays.stream(Object.class.getMethods())
				.map(method -> method.getName())
				.distinct()
				.forEach(System.out::println);


		Method[] objectMethods = Object.class.getMethods();
		Stream<Method> objectMethodStream = Arrays.stream(objectMethods);
		Stream<String> objectMethodNames = objectMethodStream.map(method -> method.getName());
		Stream<String> uniqueObjectMethodNames = objectMethodNames.distinct();
		uniqueObjectMethodNames.forEach(System.out::println);


		//Getting stream

		//You can use range or iterate factory methods in the IntStream interface.
		IntStream range = IntStream.range(1, 6);

		//The iterate() method : the initial value (as the first argument) and iteratively calls the given function (as second argument) by using the initial value as the seed.
		IntStream limit = IntStream.iterate(1, i -> i + 1).limit(5);


		//the stream() method in java.util.Arrays class to create a stream from a given array, as in:
		IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
		Stream<Integer> integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});

		//also create streams using factories and builders. The of() method is a factory method in the Stream interface:
		Stream<Integer> intStream1 = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> integerStream1 = Stream.of(new Integer[]{1, 2, 3, 4, 5});

		//use the builder() method and build the Stream object by adding each element, as in:
		Stream.builder().add(1).add(2).add(3).add(4).add(5).build();


		// for collection objects
		List<String> strings = Arrays.asList("eeny", "meeny", "miny", "mo");
		strings.stream()
				.forEach(string -> System.out.println(string));

		/*
• The lines() method in java.nio.file.Files class // returns a Stream<String>
• The splitAsStream() method in java.util.regex.Pattern class //returns a Stream<String>
• The ints() method in java.util.Random class
• The chars() method in java.lang.String class // method returns an IntStream
		 */


		Files.lines(Paths.get("./FileRead.java"))
				.forEach(System.out::println);

		Pattern.compile(" ").splitAsStream("java 8 streams")
				.forEach(System.out::println);

		new Random().ints()
				.limit(5)
				.forEach(System.out::println);

		"hello".chars()
				.sorted()
				.forEach(ch -> System.out.printf("%c ", ch));
		// prints e h l l o

		Stream.of(1, 2, 3, 4, 5)
				.peek(i -> System.out.printf("%d ", i))
				.map(i -> i * i)
				.peek(i -> System.out.printf("%d ", i)) // debugging ke liye - since non-terminal
				.count();

		//the peek() method is meant primarily for debugging purposes.
		// it helps us understand how the elements are transformed in the pipeline.
		// do not use it in production code.


		// sum(), min(), max(), or average() on an IntStream.
		// accumulating the elements with reduce(), collect() methods or
		// just calling the forEach() method.


		Object[] words = Pattern.compile(" ").splitAsStream("1 2 3 4 5")
				.toArray(); // you can convert a stream to an array and back!

		System.out.println(Arrays.stream(words)
				.mapToInt(str -> Integer.valueOf((String) str))
				.sum());


		double sum = DoubleStream.of(1.0, 4.0, 9.0)
				.map(Math::sqrt)
				.peek(System.out::println)
				.sum();
	}
}

