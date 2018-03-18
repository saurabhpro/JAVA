/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.logging;//: exceptions/LoggingExceptionsWrongOne.java
// Logging caught exceptions.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LoggingExceptionsWrongOne {
	private static final Logger logger =
			LoggerFactory.getLogger("LoggingExceptionsWrongOne");

	private static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.trace(trace.toString());
	}

	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			logException(e);
		}
	}
} /* Output: (90% match)
Aug 30, 2005 4:07:54 PM exceptions.logging.LoggingExceptionsWrongOne logException
SEVERE: java.lang.NullPointerException
        at exceptions.logging.LoggingExceptionsWrongOne.main(exceptions.logging.LoggingExceptionsWrongOne.java:16)
*///:~
