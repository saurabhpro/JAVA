/*
 * Copyright 2017 Saurabh Kumar 29/10/17 12:45 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava;

import java.util.function.BiFunction;

public class B_FirstClassCitizenVariableIllustration {

	public static void main(String[] args) {

		// ---------------------------------------------------------------------
		// This example illustrates how to create an inline lambda expression
		// and store it in a variable.  It can then be called directly from
		// the variable.
		// ---------------------------------------------------------------------
		BiFunction<String, String, String> concatFunction = (s, t) -> s + t;
		System.out.println(concatFunction.apply("Hello ", "World 1"));

		// ---------------------------------------------------------------------
		// This example illustrates how a static method that conforms to the
		// method signature of the BiFunction can be stored in a variable and
		// then invoked.
		// ---------------------------------------------------------------------
		concatFunction = (a1, b1) -> concatStrings(a1, b1);
		System.out.println(concatFunction.apply("Hello ", "World 2"));

		// ---------------------------------------------------------------------
		// This example illustrates how an instance method that conforms to the
		// method signature of the BiFunction can be stored in a variable and
		// then invoked.
		// ---------------------------------------------------------------------
		B_FirstClassCitizenVariableIllustration instance = new B_FirstClassCitizenVariableIllustration();
		concatFunction = (a, b) -> instance.concatStrings2(a, b);
		System.out.println(concatFunction.apply("Hello ", "World 3"));
	}

	private static String concatStrings(String a, String b) {
		return a + b;
	}

	/* package */ String concatStrings2(String a, String b) {
		return a + b;
	}
}
