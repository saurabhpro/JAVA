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
import java.util.function.Supplier;

public class D_HighOrderFunctionIllustration {

	public static void main(String[] args) {

		Supplier<String> xformOperation = createCombineAndTransform("Hello ", "World", (a) -> a.toUpperCase());

		// returned high order function is not called until we called get
		System.out.println(xformOperation.get());
	}

	/*
	* High order function - function that returns a function through interfaces and lambda
	 */
	public static Supplier<String> createCombineAndTransform(
			final String a, final String b,
			final Function<String, String> transformer
	) {
		return () -> {

			String aa = a;
			String bb = b;

			if (transformer != null) {
				aa = transformer.apply(a);
				bb = transformer.apply(b);
			}

			return aa + bb;
		};
	}
}
