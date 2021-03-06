/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package assertion;

/**
 * Created by Saurabh on 9/14/2015.
 */
@SuppressWarnings("ConstantConditions")
public class Assertion {

	private static int y;

	public static void foo(int x) {
		System.out.print("foo ");
		y = x;
	}

	private static int bar(int z) {
		System.out.print("bar ");
		return y = z;
	}

	private static void lookForResolveToValue() {
		try {
			int t = 0;
			assert (t > 0) : bar(7);
			//assert t > 1 : ;      //ILLEGAL
			//assert t > 1 : foo(8); /* the : part must resolve to a value of any type but void doesnt resolve to any value */
			System.out.println("done ");
		} catch (AssertionError e) {
			e.printStackTrace();
		}

	}

	static void checkForTernaryLookingCode() {
		int x = 0;
		//assert (x > 0) ? "assertion failed" : "assertion passed" ;        //requires value not ternary like

		assert (x > 0) : "assertion failed";       //correct, as resolves to a value
		assert (x > 0);
		//assert(boolean);  //is the simple way to write assertion
		System.out.println("finished");
	}

	public static void main(String[] args) {
		lookForResolveToValue();

	}
}
