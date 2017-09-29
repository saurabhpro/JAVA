/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package maps.flatmap;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMapToString {

	public static void main(String[] args) {

		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		//Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);

		//filter a stream of string[], and return a string[]?
		//Stream<String[]> stream = temp.filter(x -> "a".equals(Arrays.toString(x)));

		//stream.forEach(System.out::println);


		//so we should have done this instead
		//Stream<String>, GOOD!
		Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
		//forEach consumes stream - hence "stream has already been operated upon or closed" after the below print
		//stringStream.forEach(System.out::println);

		Stream<String> stream2 = stringStream.filter(x -> "a".equals(x));

		/*Stream<String> stream = Arrays.stream(data)
		        .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()));*/


		stream2.forEach(System.out::println);

	}

}