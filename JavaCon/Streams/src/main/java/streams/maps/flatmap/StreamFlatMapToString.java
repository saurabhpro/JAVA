/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.maps.flatmap;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMapToString {

	//Flatmap -> [[a,b],[c,d,e]] f(x) =>[f(a),f(b),f(c),f(d),f(e)]

	public static void main(String[] args) {

		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		//Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);

		//filter a stream of string[], and return a string[]?
		//Stream<String[]> stream = temp.filter(x -> "a".equals(Arrays.toString(x)));

		//stream.forEach(System.out::println);


		//so we should have done this instead
		//Stream<String>, GOOD!
		@SuppressWarnings("Convert2MethodRef") Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
		//forEach consumes stream - hence "stream has already been operated upon or closed" after the below print
		stringStream.forEach(System.out::println);

		@SuppressWarnings("Convert2MethodRef") Stream<String> stream2 = stringStream.filter(x -> "a".equals(x));

		/*Stream<String> stream = Arrays.stream(data)
		        .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()));*/


		stream2.forEach(System.out::println);

	}

}