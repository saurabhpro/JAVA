/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package general;

/**
 * This class is for testing HTML5 Javadoc.
 * <p>
 * Use -html5 to build in html5 else default is still html4
 *
 * @author Saurabh
 * @version 01
 */

public class Html5DocumentationGenerator {

	/**
	 * Run test for input Id.
	 * <p>
	 * Note: input Id should <strong>not</strong> be null.
	 *
	 * @param id the input id to test
	 * @return the String of test result, <strong>"Wrong id!"</strong> if {@code id < 0}
	 * @throws NullPointerException if id is {@code null}
	 * @since 9
	 */

	public static String runTest(Integer id) {

		if (id == null) {
			throw new NullPointerException();
		}
		if (id < 0) {
			return "Wrong id!";
		}

		return "Run Test for id: " + id;
	}
}
