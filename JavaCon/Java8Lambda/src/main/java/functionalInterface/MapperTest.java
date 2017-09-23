/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package functionalInterface;// functionalInterface.MapperTest.java

@FunctionalInterface
interface Mapper<T> {
	// A generics static method
	static <U> int[] mapToInt(U[] list, Mapper<? super U> mapper) {
		int[] mappedValues = new int[list.length];

		for (int i = 0; i < list.length; i++) {
			// Map the object to an int
			mappedValues[i] = mapper.map(list[i]);
		}

		return mappedValues;
	}

	// An abstract method
	int map(T source);
}

public class MapperTest {
	public static void main(String[] args) {
		// Map names using their length
		System.out.println("Mapping names to their lengths:");
		String[] names = {"David", "Li", "Doug"};
		int[] lengthMapping = Mapper.mapToInt(names, (String name) -> name.length());
		printMapping(names, lengthMapping);

		System.out.println("\nMapping integers to their squares:");
		Integer[] numbers = {7, 3, 67};
		int[] countMapping = Mapper.mapToInt(numbers, (Integer n) -> n * n);
		printMapping(numbers, countMapping);
	}

	private static void printMapping(Object[] from, int[] to) {
		for (int i = 0; i < from.length; i++) {
			System.out.println(from[i] + " mapped to " + to[i]);
		}
	}
}
