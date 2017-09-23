/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo04.langandlib.language;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class TryWithResources {

	public static Logger logger = Logger.getLogger(TryWithResources.class.getName());

	public void normalTryWithResources() throws IOException {
		try (FileInputStream fis = new FileInputStream("~/tmp/test")) {
			fis.read();
		}
	}

	public void doWithFile(FileInputStream fis) throws IOException {

		// fis = null; // Re-assignment makes fis not 'effectively final'
		try (FileInputStream fis2 = fis) {
			fis2.read();
		}

		// Only if fis is 'effectively final', can this form be used
		try (fis) {
			fis.read();
		}

	}
}
