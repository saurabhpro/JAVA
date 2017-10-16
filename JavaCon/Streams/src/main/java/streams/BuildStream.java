/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
