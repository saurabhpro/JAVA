/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions;/*
  Created by Saurabh on 9/25/2015.
 */

/**
 * the keyword throw produces exception object on the heap with new throw(...) keyword.
 * the current path of execution is TERMINATED** and the reference for the exception
 * object is returned/ejected from the current context.
 * <p>
 * Now the exception handler mechanism takes charge whose job is to recover from the problem.
 */

public class ExceptionClassMethods {

	public static void main(String[] args) {
		ExceptionClassMethods.StackTrace trace = new ExceptionClassMethods.StackTrace();
		trace.stackTrace();


		//More Methods
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			System.out.println("Caught Exception");
			System.out.println("getMessage():" + e.getMessage());
			System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
			System.out.println("toString():" + e);
			System.out.println("printStackTrace():");
			e.printStackTrace(System.out);
		}

		System.out.println("Can you reach here - YESS");
	}

	static class StackTrace {
		static void f() {
			// Generate an exception to fill in the stack trace
			try {
				throw new Exception();
			} catch (Exception e) {
				for (StackTraceElement ste : e.getStackTrace())
					System.out.println(ste.getMethodName());
			}
		}

		static void g() {
			f();
		}

		static void h() {
			g();
		}

		void stackTrace() {
			f();
			System.out.println("--------------------------------");
			g();
			System.out.println("--------------------------------");
			h();
			System.out.println("--------------------------------");
		}
	}
}
