/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.finally_throws;//: exceptions/exceptions.finally_throws.Rethrowing.java
// Demonstrating fillInStackTrace()

public class Rethrowing {
	private static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
		//this string argument  doesn't get printed unless stacktrace called in catch block of callee
	}

	private static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside g(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}

	private static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside h(),e.printStackTrace()");
			e.printStackTrace(System.out);

			throw (Exception) e.fillInStackTrace();

			/*Records information within this Throwable object about the current state of the stack frames.
			  Useful when an application is rethrowing an error or exception

			  If you simply rethrow the current exception, the information that you print about that exception
			  in printStackTrace( ) will pertain to the exception�s origin, not the place where you rethrow it.

			  If you want to install new stack trace information, you can do so by calling fillInStackTrace( ),
			  which returns a Throwable object that it creates by stuffing the current stack information
			  into the old exception object.
			 */
		}
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
			/*
			java.lang.Exception: thrown from f()
            at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
            at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:23)
            at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:53)
             */
		}

		System.out.println("\nNow see the difference when fillinStackTrace is called\n");

		try {
			h();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
	        /*
	        java.lang.Exception: thrown from f()
            at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:23)
            at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:53)
             */
		}
	}
} /* Output:
originating the exception in f()
Inside g(),e.printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
        at exceptions.finally_throws.Rethrowing.g(exceptions.finally_throws.Rethrowing.java:11)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:29)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
        at exceptions.finally_throws.Rethrowing.g(exceptions.finally_throws.Rethrowing.java:11)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:29)
originating the exception in f()
Inside h(),e.printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
        at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:20)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:35)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:24)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:35)
*///:~
