/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.logging;//: exceptions/exceptions.logging.LoggingExceptions.java
// An exception that reports through a Logger.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

class LoggingException extends Exception {
    private static final Logger LOG = LoggerFactory.getLogger(LoggingException.class);

    LoggingException() {
        LOG.info(LOG.getName());

        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        LOG.trace(trace.toString());
    }
}

public class LoggingExceptions {
    private static final Logger LOG = LoggerFactory.getLogger(LoggingExceptions.class);

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            LOG.error("Caught ", e.fillInStackTrace());
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            LOG.error("Caught ", e.fillInStackTrace());
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
