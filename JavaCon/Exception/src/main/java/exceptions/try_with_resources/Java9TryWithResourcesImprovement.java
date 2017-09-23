/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("JavaDoc")
class Java9TryWithResourcesImprovement {
	/**
	 * Here we have created an utility method which creates a BufferedReader object to read the content of a file.
	 * If we observe the above code snippet, even though we have reader1 referring to BufferedReader object,
	 * we should create a duplicate one “reader2” to use it in Try-With-Resources.
	 * <p>
	 * It is one small bug or issue in Java SE 7 or 8 versions.
	 * <p>
	 * We cannot use any Resource (which is declared outside the Try-With-Resources) within try() block of Try-With-Resources statement.
	 * <p>
	 *
	 * @throws IOException
	 */
	void testARM_Java8() throws IOException {
		//noinspection UnnecessaryLocalVariable
		BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
		try (BufferedReader reader2 = reader1) {
			System.out.println(reader2.readLine());
		}
	}

	/**
	 * Below code is invalid in Java SE 7 or 8 versions. It throws compile-time error.
	 *
	 * @throws IOException
	 */
	void testARM_Java9() throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
		try (reader1) {
			System.out.println(reader1.readLine());
		}
	}
}
