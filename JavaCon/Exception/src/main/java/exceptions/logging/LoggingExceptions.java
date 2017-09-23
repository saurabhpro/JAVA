package exceptions.logging;//: exceptions/exceptions.logging.LoggingExceptions.java
// An exception that reports through a Logger.

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception {
	private static final Logger logger = Logger.getLogger(LoggingException.class.getName());

	LoggingException() {
		System.out.println(logger.getName());

		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
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
