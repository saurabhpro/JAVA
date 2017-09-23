/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.util.function.LongFunction;

/**
 * Created by Saurabh on 2/27/2016.
 * <p>
 * Lambda functions can't be recursive
 */
public class RecursiveMethodReference {
	public static void main(String[] args) {
		LongFunction<Long> p = RecursiveMethodReference::factorial;    //IntFunction only cares about return type

		long val = 9;
		long result = p.apply(val);     //IntFunction cant be applied to long, so used LongFunction
		System.out.println("Factorial of " + val + " = " + result);

	}

	private static long factorial(long num) {
		if (num == 0 || num == 1)
			return 1;
		else
			return num * factorial(num - 1);
	}
}
