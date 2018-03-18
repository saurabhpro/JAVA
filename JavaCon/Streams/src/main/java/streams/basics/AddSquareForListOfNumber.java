/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.basics;

import streams.model.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Saurabh on 2/27/2016.
 */
public class AddSquareForListOfNumber {
	public static void main(String[] args) {
		List<Integer> numbers = DataProvider.numberList;

		Stream<Integer> simpleNumberedStream = numbers.stream();
		Stream<Integer> filteredNumberedStream = simpleNumberedStream.filter(n -> n % 2 == 0);

        /*

        try {
            Stream<Integer> c = simpleNumberedStream.filter(n-> n%2 == 0);
        }catch (Exception e){
            System.out.println(e+" => exception caught");
        }
*/
		Stream<Integer> mapNumberStream = filteredNumberedStream.map(n -> n * n);
		List<Integer> list = new ArrayList<>();
		mapNumberStream.forEach(list::add);

		//we cant reuse a stream
		int reducedNumberStream = numbers.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> n * n)
				.reduce(0, Integer::sum);       //first arg = initial value
		//second arg is the function that will be applied onto arg1 again and again

		System.out.println("sum of squares of " + numbers + " => " + list + "   = " + reducedNumberStream);

		numbers.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> n * n)
				.forEach(System.out::println);

		Stream.of(1, 2, 3, 4, 5, 6)
				.filter(n -> n % 2 == 0)
				.map(n -> n * n)
				.forEach(System.out::println);
	}
}
