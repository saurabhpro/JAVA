/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package generics.inheritance;

/**
 * Created by Saurabh on 8/13/2015.
 */
public class LocalExtendsBounds {

	private static <T, V extends T> boolean isIn(T x, V[] y) {
		for (V i : y)                //for each loop
			if (x.equals(i))        //autoboxing as equals compares two objects
				return true;

		return false;
	}

	private static <T extends Number> double add(T x, T y) {
		return x.doubleValue() + y.doubleValue();
		//+ cannot be applied on T types so x+y is an error
	}

	public static void main(String[] args) {

		Integer[] nums = {1, 2, 3, 4, 5};
		if (isIn(2, nums))
			System.out.println(2 + " is in Nums");

		if (!isIn(7, nums))
			System.out.println(7 + " is not in Num");


		String[] st = {"One", "Two", "Three", "Four", "Five"};
		if (isIn("Two", st))
			System.out.println("Two is in st");

		if (!isIn("Seven", st))
			System.out.println("Seven is not is st");

		System.out.println(add(10, 20));
		System.out.println(add(10.5, 10));
		System.out.println(add(10.2f, 18.8f));      //outputs 28.999999046325684 instead of 29

	}
}
