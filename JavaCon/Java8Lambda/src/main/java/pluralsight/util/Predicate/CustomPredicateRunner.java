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

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class CustomPredicateRunner {
	public static void main(String[] args) {

		//old ways of writing anonymous class
		Predicate<Integer> predicate = new Predicate<>() {
			@Override
			public boolean test(Integer integer) {
				return integer > 20;
			}
		};

		System.out.println(predicate.test(45));


		//new way of implementing abstract method of functional interface
		Predicate<String> stringPredicate = s -> s.length() > 20;

		System.out.println(stringPredicate.test("Helloo"));


		Predicate<String> p1 = s -> s.length() < 20;
		Predicate<String> p2 = s -> s.length() > 5;

		boolean b = p1.test("Hello");
		System.out.println("Hello is shorter than 20 chars : " + b);

		Predicate<String> p3 = p1.and(p2);

		System.out.println("P3 for Yes: " + p3.test("Yes"));
		System.out.println("P3 for Good morning: " + p3.test("Good morning"));
		System.out.println("P3 for Good morning gentlemen: " + p3.test("Good morning gentlemen"));

		Predicate<String> p4 = p1.or(p2);

		System.out.println("P4 for Yes: " + p4.test("Yes"));
		System.out.println("P4 for Good morning: " + p4.test("Good morning"));
		System.out.println("P4 for Good morning gentlemen: " + p4.test("Good morning gentlemen"));

		Predicate<String> p5 = Predicate.isEqualsTo("Yes");

		System.out.println("P5 for Yes: " + p5.test("Yes"));
		System.out.println("P5 for No: " + p5.test("No"));

		Predicate<Integer> p6 = Predicate.isEqualsTo(1);
	}


}
