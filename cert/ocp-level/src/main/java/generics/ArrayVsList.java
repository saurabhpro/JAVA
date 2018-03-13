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

