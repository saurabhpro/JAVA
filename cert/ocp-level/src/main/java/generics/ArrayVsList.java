package generics;

import java.util.ArrayList;
import java.util.List;

public class ArrayVsList {
	public static void main(String[] args) {
		/*
		 * With arrays, Java knows the type that is allowed in the array.
		 * Just because we’ve assigned an Integer[] to an Object[]
		 * doesn’t change the fact that Java knows it is really an Integer[].
		 */
		Integer[] integers = {1, 6, 9};

		Object[] objects = integers;

		// objects[0] = "forty two";
		// the above code compiles -  but throws runtime exception



		/*
		 * Due to type erasure, we have no such protection for an ArrayList.
		 * At runtime, the ArrayList doesn’t know what is allowed in it.
		 *
		 * Therefore, Java uses the compiler to prevent this situation from coming up in the first place.
		 */

		List<Integer> numbers = new ArrayList<>();
		numbers.add(42);

		// List<Object> objects = numbers; // DOES NOT COMPILE
		// hence to overcome this java uses
		List<?> objects1 = numbers;
		System.out.println(objects1);


	}

}

class BoundsInGeneric {
	public static void main(String[] args) {
		// Something interesting happens when we work with upper bounds or unbounded wild-cards.
		// The list becomes logically immutable.

		List<?> unboundedList = new ArrayList<String>();
		// unboundedList.add("Hi");
		System.out.println(unboundedList);


		List<? extends Bird> upperBoundedList = new ArrayList<Bird>();
		// upperBoundedList.add(new Sparrow()); // DOES NOT COMPILE
		// upperBoundedList.add(new Bird()); // DOES NOT COMPILE
		// From Java’s point of view, both scenarios are equally possible so neither is allowed.
		List<Integer> keywords = new ArrayList<>();
		keywords.add(66);
		printList(keywords);    // so passing is the main objective

		// With a lower bound, we are telling Java that the list will be
		// a list of String objects or a list of some objects that are a superclass of String.
		// Either way, it is safe to add a String to that list.

		//lower bounds are fine with modification
		List<? super Bird> lowerBoundedList = new ArrayList<Bird>();
		lowerBoundedList.add(new Sparrow());
		lowerBoundedList.add(new Bird());   // anything lowed than Bird class will go
		// lowerBoundedList.add(new Animal());  // parent of Bird
		// lowerBoundedList.add(new Object());  // parent of everything
		System.out.println(lowerBoundedList);


		List<String> strings = new ArrayList<>();
		strings.add("tweet");
		List<Object> objects = new ArrayList<>(strings);
		objects.add(99);
		addSound(strings);
		addSound(objects);  // so passing is the main objective
		System.out.println(objects); // no exception
	}

	private static void printList(List<? extends Number> list) {
		for (Number x : list)
			System.out.println(x);
	}

	private static void addSound(List<? super String> list) {
		list.add("quack");
	}

	static class Sparrow extends Bird {
		@Override
		public String toString() {
			return "Sparrow{}";
		}
	}

	static class Bird extends Animal {
		@Override
		public String toString() {
			return "Bird{}";
		}
	}

	static class Animal {
		@Override
		public String toString() {
			return "Animal{}";
		}
	}

}
