/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.dispose;//: exceptions/exceptions.dispose.InputFile.java
// Paying attention to exceptions in constructors.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class InputFile {
	private BufferedReader in;

	public InputFile(String fname) throws Exception {
		//noinspection EmptyFinallyBlock
		try {
			in = new BufferedReader(new FileReader(fname));
			// Other code that might throw exceptions
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + fname);
			// Wasn't open, so don't close it
			throw e;
		} catch (Exception e) {
			// All other exceptions must close it
			try {
				in.close();
			} catch (IOException e2) {
				System.out.println("in.close() unsuccessful");
			}
			throw e; // Rethrow
		} finally {
			// Don't close it here!!!
		}
	}

	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readLine() failed");
		}
		return s;
	}

	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() successful");
		} catch (IOException e2) {
			throw new RuntimeException("in.close() failed");
		}
	}
} ///:~
