/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams;


import streams.model.DataProvider;
import streams.model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by saurabhkumar on 24/05/17.
 */
@SuppressWarnings("unused")
public class BuildStream {
	public static void main(String[] args) {
		List<Person> list = DataProvider.getYoungPersonList();

		Stream<Person> personStream = list.stream();

		//Stream<T> interface having static methods
		//empty Stream
		Stream<?> empty = Stream.empty();       // ? = Object

		//of
		Stream<String> one = Stream.of("One");
		Stream<String> one1 = Stream.of("One", "two", "three");

		//a constant stream using Supplier
		Stream<String> generate = Stream.generate(() -> "one");

		//iterate over a growing stream
		Stream<String> iterate = Stream.iterate(" + ", s -> s + " + ");

		//random class stream
		ThreadLocalRandom.current().ints();

		//int stream on array of characters
		IntStream intStream = "hello".chars();

		//stream builder
		Stream.Builder<String> builder = Stream.builder();
		builder.add("One").add("two").accept("four");

		Stream<String> stringStream = builder.build();
		stringStream.forEach(System.out::println);

		//once build() is called on builder you cannot add /accept to it


		Map<String, Person> map = new HashMap<>();
		int n = list.size();

		IntStream.range(0, list.size()).forEach(i -> map.putIfAbsent("" + i, list.get(i)));

		//Stream.of(map).filter( );


	}
}
