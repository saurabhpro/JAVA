/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions;//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}

/**
 * RuntimeException (or anything inherited from it) is a special case,
 * since the compiler doesn�t require an exception specification for these types.
 * The output is reported to System.err:
 * <p>
 * You never need to write an exception specification saying that a method might
 * throw a RuntimeException (or any type inherited from RuntimeException),
 * because they are unchecked exceptions. [you cant do anything about it]
 * <p>
 * If a RuntimeException gets all the way out to main( ) without being caught,
 * printStackTrace( ) is called for that exception as the program exits.
 */
public class RuntimeNeverCaught {
	private static void f() throws IllegalArgumentException, IndexOutOfBoundsException {
		throw new RuntimeException("From f()");
	}

	private static void g() {
		f();
	}

	public static void main(String[] args) {
		g();
	}
} ///:~
