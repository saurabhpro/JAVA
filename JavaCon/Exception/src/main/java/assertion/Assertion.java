/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
