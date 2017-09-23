/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.dispose;//: exceptions/exceptions.dispose.Cleanup.java
// Guaranteeing proper cleanup of a resource.

public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("Cleanup.java");
			try {
				String s;
				int i = 1;
				//noinspection StatementWithEmptyBody
				while ((s = in.getLine()) != null)
					; // Perform line-by-line processing here...
			} catch (Exception e) {
				System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			} finally {
				in.dispose();
			}
		} catch (Exception e) {
			System.out.println("exceptions.InputFile construction failed");
		}
	}
}
/* Output: (if Cleanup.java is found)
dispose() successful
*///:~
