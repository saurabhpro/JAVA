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

import java.util.function.Function;

public class C_FirstClassCitizenParameterIllustration {

	public static void main(String[] args) {

		// The concatAndTransform call illustrates how fuctions can be passed
		// as a parameter.  Functions (lambdas) can be passed directly or...
		System.out.println(concatAndTransform("Hello ", "World", (s) -> s.toUpperCase()));

		// ...from a variable.
		Function<String, String> transformToLower = (s) -> s.toLowerCase();
		System.out.println(concatAndTransform("Hello ", "World", transformToLower));
	}

	public static String concatAndTransform(String a, String b, Function<String, String> stringTransform) {

		// NOTE: Please see the "Optional" class in Java 8...it would be more
		// correct that what I'm doing here. I just didn't want to confuse
		// the point about functions as parameters.
		if (stringTransform != null) {
			a = stringTransform.apply(a);
			b = stringTransform.apply(b);
		}

		return a + b;
	}
}
