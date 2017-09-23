/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.finally_throws;//: exceptions/exceptions.finally_throws.LostMessage.java
// How an exception can be lost. Flaw in java Exception handling

/**
 * when try and finally generate exception , priority always goes to finally one
 */


public class LostMessage {
	/**
	 * even simpler way to lose an exception is just to return from inside a finally clause
	 * If you run this program you'll see that it produces no output, even though an exception is thrown.
	 */
	@SuppressWarnings("ReturnInsideFinallyBlock")
	private static void ExceptionSilencer() {
		//noinspection finally
		try {
			throw new RuntimeException();
		} finally {
			// Using 'return' inside the finally block
			// will silence any thrown exception.
			//works even in java 9 - intellij thinks its unnecessary
			//noinspection UnnecessaryReturnStatement
			return;
		}
	}

	public static void main(String[] args) {
		try {
			LostMessage.ExceptionSilencer();

			LostMessage lm = new LostMessage();
			try {
				lm.f();         //ex 1
			} finally {
				lm.dispose();   //ex 2
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	private void dispose() throws HoHumException {
		throw new HoHumException();
	}

	class VeryImportantException extends Exception {
		@Override
		public String toString() {
			return "exceptions.try_with_resources.A very important exception!";
		}
	}

	class HoHumException extends Exception {
		@Override
		public String toString() {
			return "exceptions.try_with_resources.A trivial exception";
		}
	}
} /* Output:
exceptions.try_with_resources.A trivial exception
*///:~