/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

// ArithOperator.java

public class ApressArithOperator {

	public static void main(String[] args) {
		int num = 120;
		double realNum = 25.5F;
		double veryBigNum = 25.8 / 0.0;
		double garbage = 0.0 / 0.0;
		boolean test = true;

		// Print the value of num
		System.out.println("num = " + num);

		// Print the value of realNum
		System.out.println("realNum = " + realNum);

		// Print the value of veryBigNum
		System.out.println("veryBigNum = " + veryBigNum);

		// Print the value of garbage
		System.out.println("garbage = " + garbage);

		// Print the value of test
		System.out.println("test = " + test);

		// Print the maximum value of int type
		System.out.println("Maximum int = " + Integer.MAX_VALUE);

		// Print the maximum value of double type
		System.out.println("Maximum double = " + Double.MAX_VALUE);

		// Print the sum of two numbers
		System.out.println("12.5 + 100 = " + (12.5 + 100));

		// Print the difference of two numbers
		System.out.println("12.5 - 100 = " + (12.5 - 100));

		// Print the multiplication of two numbers
		System.out.println("12.5 * 100 = " + (12.5 * 100));

		// Print the result of division
		System.out.println("12.5 / 100 = " + (12.5 / 100));

		// Print the result of modulus
		System.out.println("12.5 % 100 = " + (12.5 % 100));

		// Print the result of string concatenation
		System.out.println("\"abc\" + \"xyz\" = " + "\"" + ("abc" + "xyz") + "\"");

	}

	void newStuff() {
		double d1, d2;
		boolean b;

		d1 = Double.NaN;
		d2 = Double.NaN;
		b = (d1 == d2); // Assigns false to b as two NaN cant be equal
	}
}
