package generics.bounds;

import java.util.ArrayList;
import java.util.List;

public class BoundsInGeneric {

	public static void main(String[] args) {
		// Something interesting happens when we work with upper bounds or unbounded wild-cards.
		// The list becomes logically immutable.

		unbounded();


		upperBound();

		lowerBound();
	}

	private static void unbounded() {
		List<?> unboundedList = new ArrayList<String>();
		// unboundedList.add("Hi");
		System.out.println(unboundedList);
	}

	private static void upperBound() {
		List<? extends Bird> upperBoundedList = new ArrayList<Bird>();
		// upperBoundedList.add(new Sparrow()); // DOES NOT COMPILE
		// upperBoundedList.add(new Bird()); // DOES NOT COMPILE
		// From Java’s point of view, both scenarios are equally possible so neither is allowed.

		List<Sparrow> sparrows = new ArrayList<>();
		sparrows.add(new Sparrow());
		birdEx(sparrows);


		List<Integer> keywords = new ArrayList<>();
		keywords.add(66);
		printList(keywords);    // so passing is the main objective
	}

	private static void lowerBound() {
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


		// case 2
		// here we can have anything > Bird class (while declaration - even though you can put child in the list)
		List<Animal> sparrows = new ArrayList<>();
		sparrows.add(new Animal());    // this is polymorphic behavior
		birdSu(sparrows);


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

		// list.add("gg");  // still not possible
	}

	private static void addSound(List<? super String> list) {
		list.add("quack");
	}

	private static void birdEx(List<? extends Bird> list) {
		System.out.print("Extends <= Bird : ");
		for (Bird x : list)
			System.out.println(x);

		// list.add("gg");  // still not possible
	}

	private static void birdSu(List<? super Bird> list) {
		System.out.print("Super >= Bird : ");
		// list.add(new Animal());   // while passing List<Animal> was allowed - but you can't add > Bird directly - OOPS concept!
		list.add(new Bird());
		list.add(new Sparrow());    // polymorphic
		System.out.println(list);
	}

	static class Animal {
		@Override
		public String toString() {
			return "Animal{}";
		}
	}

	static class Bird extends Animal {
		@Override
		public String toString() {
			return "Bird{}";
		}
	}

	static class Sparrow extends Bird {
		@Override
		public String toString() {
			return "Sparrow{}";
		}
	}

}
