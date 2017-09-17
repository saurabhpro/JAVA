package pluralsight.util.streams;

import pluralsight.util.common.Person;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by saurabhkumar on 24/05/17.
 */
public class BuildStream {
	public static void main(String[] args) {
		Person p1 = new Person("Alice", 23);
		Person p2 = new Person("Brian", 56);
		Person p3 = new Person("Chelsea", 46);
		Person p4 = new Person("David", 28);
		Person p5 = new Person("Erica", 37);
		Person p6 = new Person("Francisco", 18);

		List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));


		Stream<Person> personStream = list.stream();

		//Stream<T> interface having static methods
		//empty Stream
		Stream.empty();

		//of
		Stream.of("One");
		Stream.of("One", "two", "three");

		//a constant stream using Supplier
		Stream.generate(() -> "one");

		//iterate over a growing stream
		Stream.iterate(" + ", s -> s + " + ");

		//random class stream
		ThreadLocalRandom.current().ints();

		//int stream on array of charecters
		IntStream intStream = "helo".chars();

		//stream builder
		Stream.Builder<String> builder = Stream.builder();
		builder.add("One").add("two").accept("four");

		Stream<String> stringStream = builder.build();
		stringStream.forEach(System.out::println);

		//once build() is called on builder you cannot add /accept to it


		Map<String, Person> map = new HashMap<>();
		map.putIfAbsent("1", p1);
		map.putIfAbsent("2", p2);
		map.putIfAbsent("3", p3);
		map.putIfAbsent("4", p4);
		map.putIfAbsent("5", p5);
		map.putIfAbsent("6", p6);

		//Stream.of(map).filter( );


	}
}
