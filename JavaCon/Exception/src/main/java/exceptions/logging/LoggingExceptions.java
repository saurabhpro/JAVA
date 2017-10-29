/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.logging;//: exceptions/exceptions.logging.LoggingExceptions.java
// An exception that reports through a Logger.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

class LoggingException extends Exception {
	private static final Logger logger = LoggerFactory.getLogger(LoggingException.class.getName());

	LoggingException() {
		System.out.println(logger.getName());

		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.trace(trace.toString());
	}
}

public class LoggingExceptions {
	public static void main(String[] args) {
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
	}
} /* Output: (85% match)
Aug 30, 2005 4:02:31 PM exceptions.logging.LoggingException <init>
SEVERE: exceptions.logging.LoggingException
        at exceptions.logging.LoggingExceptions.main(exceptions.logging.LoggingExceptions.java:19)

Caught exceptions.logging.LoggingException
Aug 30, 2005 4:02:31 PM exceptions.logging.LoggingException <init>
SEVERE: exceptions.logging.LoggingException
        at exceptions.logging.LoggingExceptions.main(exceptions.logging.LoggingExceptions.java:24)

Caught exceptions.logging.LoggingException
*///:~
