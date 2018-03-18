/*
 * Copyright (c) 2018 Saurabh Kumar
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
