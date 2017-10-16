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
		ArrayList<Integer> list = new ArrayList<>();
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
