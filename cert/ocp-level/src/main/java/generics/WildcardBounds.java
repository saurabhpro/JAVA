package generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WildcardBounds {

	// makes room for any type extending number - mind it they are now treated as number and not that type
	public static long total(List<? extends Number> list) {
		long count = 0;
		for (Number number : list)
			count += number.longValue();
		return count;
	}

	public static void main(String[] args) {
		List<?> l = new ArrayList<String>();
		List<? extends Exception> l1 = new ArrayList<RuntimeException>();
		// l1.add(new IOException());
		// l1.add(new RuntimeException());
		// l1.add(new FileNotFoundException()); // TODO why ?

		List<? super IOException> l2 = new ArrayList<Exception>();
		// does not compile because we could have a List<IOException> and an Exception object wouldn’t in there.
		// l2.add(new Object());
		// l2.add(new Exception()); // DOES NOT COMPILE
		l2.add(new IOException());
		l2.add(new FileNotFoundException());
		/*
		FileNotFoundException is a subclass of IOException and the keyword says super. What happens is that Java says
		“Well, FileNotFoundException also happens to be an IOException, so everything is  fine.”
		 */
		// l2.add(new RuntimeException());


		// incompatible types: java.util.ArrayList<java.lang.String> cannot be converted to java.util.List<java.lang.Object>
		// List<Object> l4 = new ArrayList<String>();

		// incompatible types: java.util.List<capture#1 of ?> cannot be converted to java.util.List<? extends java.lang.Number>
		// System.out.println(total(l));
	}

}

class A {
}

class B extends A {

	<B extends A> B method3(List<B> list) {
		// Since B no longer refers to the B class in the method arg, you can’t instantiate it.
		// B here means B C or A itself

		//return new B(); // DOES NOT COMPILE
		return null;
	}
}

class C extends B {

	<X> void method5(List<? super B> list) {
		//<A super B> // DOES NOT COMPILE
		// it tries to mix a method-specific type parameter with a wildcard. A wildcard must have a ? in it.
	}
}
