package generics;

import java.util.ArrayList;
import java.util.List;

public class CannotDoWithNonReifiable<T> {
	/*
	// non-static type variable T cannot be referenced from a static context

	private static T num ;  //T is bound to this which is not available until class generation

	// omits the formal parameter type, and therefore it does not compile.
	private static T getValue(){
		int r = 8;
		return (T) r;
	}
	*/

	private T num;  // allowed

	public static void main(String[] args) {
		// List<int> in = new ArrayList<>(); //primitive

		// However this is indeed object
		List<int[]> in = new ArrayList<>();

		// illegal generic type for instanceof
		// boolean rv = in instanceof List<int[]>;

		CannotDoWithNonReifiable<Integer> ct = new CannotDoWithNonReifiable<>();

		//CannotDoWithNonReifiable<Integer>[] ct2 = new CannotDoWithNonReifiable<Integer>[4];
		// array of generics is not possible

		// array of objects however is
		CannotDoWithNonReifiable<Integer>[] ct2 = new CannotDoWithNonReifiable[4];

		CannotDoWithNonReifiable.<Integer>ship(87);
	}

	public static <T> T ship(T t) {
		System.out.println("Preparing " + t);
		return t;
	}

}
