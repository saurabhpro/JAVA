/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.util.Predicate;

import java.util.function.IntPredicate;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class UtilPredicateRunner {

	public static void main(String[] args) {
		java.util.function.Predicate<String> javaPredicate = s -> s.equals("Check it");
		java.util.function.Predicate<String> javaPredicate2 = s -> s.length() < 20;

		System.out.println(javaPredicate.negate());
		java.util.function.Predicate<String> negatedJavaPredicate = javaPredicate.negate();

		System.out.println(javaPredicate.test("Hi"));
		System.out.println(javaPredicate.and(javaPredicate2).test("Hi"));
		System.out.println(javaPredicate.or(javaPredicate2).test("Hi"));

		IntPredicate intPredicate = s -> s > 5;
	}
}
