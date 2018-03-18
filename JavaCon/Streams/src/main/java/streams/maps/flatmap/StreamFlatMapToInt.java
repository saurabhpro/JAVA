/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.maps.flatmap;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFlatMapToInt {

	public static void main(String[] args) {

		int[] intArray = {1, 2, 3, 4, 5, 6};

		//1. Stream<int[]>
		Stream<int[]> streamArray = Stream.of(intArray);

		//2. Stream<int[]> -> flatMap -> IntStream
		@SuppressWarnings("Convert2MethodRef") IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

		//noinspection Convert2MethodRef
		intStream.forEach(x -> System.out.println(x));

	}

}