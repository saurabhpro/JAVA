/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.finally_throws;

import java.util.ConcurrentModificationException;

import static java.lang.System.exit;
import static java.lang.System.out;

/**
 * Created by Saurabh on 8/23/2015.
 */
public class ReturnFinally {
	private static int count;

	private static Exception Ret() {
		//noinspection finally
		try {
			throw new NoSuchFieldException();
		} catch (Exception e) {
			//noinspection finally
			try {
				return new NullPointerException();
			} finally {
				//noinspection ReturnInsideFinallyBlock
				return new ClassCastException();
			}

		} finally {
			//noinspection ReturnInsideFinallyBlock
			return new ConcurrentModificationException();       //overrides all return statements
		}
	}

	private static void finallyAlwaysRuns() {
		while (true) {
			try {
				// Post-increment is zero first time:
				if (count++ == 0)
					throw new ArithmeticException();
				System.out.println("No exception");
			} catch (ArithmeticException e) {
				System.out.println("ArithmeticException");
			} finally {
				System.out.println("In finally clause");
				if (count == 2) //noinspection ContinueOrBreakFromFinallyBlock
					break; // out of "while"
			}
		}
	}

	public static void main(String[] args) {
		out.println(Ret().toString());

		System.out.println("\nCheck if finally always runs\n");
		finallyAlwaysRuns();

		exit(5);        //simply shows exit status as 5
	}
}
