/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.finally_throws;//: exceptions/exceptions.finally_throws.Rethrowing.java
// Demonstrating fillInStackTrace()

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rethrowing {
    private static final Logger LOG = LoggerFactory.getLogger(Rethrowing.class);

    private static void f() throws Exception {
        LOG.info("originating the exception in f()");
        throw new Exception("thrown from f()");
        //this string argument  doesn't get printed unless stacktrace called in catch block of callee
    }

    private static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            LOG.error("Inside g(),e.printStackTrace()", e);
            throw e;
        }
    }

    private static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            LOG.error("Inside h(),e.printStackTrace()", e);

            throw (Exception) e.fillInStackTrace();

			/*Records information within this Throwable object about the current state of the stack frames.
			  Useful when an application is rethrowing an error or exception

			  If you simply rethrow the current exception, the information that you print about that exception
			  in printStackTrace( ) will pertain to the exception�s origin, not the place where you rethrow it.

			  If you want to install new stack trace information, you can do so by calling fillInStackTrace( ),
			  which returns a Throwable object that it creates by stuffing the current stack information
			  into the old exception object.
			 */
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            LOG.error("main: printStackTrace()", e);
			/*
			java.lang.Exception: thrown from f()
            at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
            at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:23)
            at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:53)
             */
        }

        LOG.info("\nNow see the difference when fillinStackTrace is called\n");

        try {
            h();
        } catch (Exception e) {
            LOG.error("main: printStackTrace()", e);
	        /*
	        java.lang.Exception: thrown from f()
            at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:23)
            at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:53)
             */
        }
    }
} /* Output:
originating the exception in f()
Inside g(),e.printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
        at exceptions.finally_throws.Rethrowing.g(exceptions.finally_throws.Rethrowing.java:11)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:29)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
        at exceptions.finally_throws.Rethrowing.g(exceptions.finally_throws.Rethrowing.java:11)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:29)
originating the exception in f()
Inside h(),e.printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.f(exceptions.finally_throws.Rethrowing.java:7)
        at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:20)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:35)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at exceptions.finally_throws.Rethrowing.h(exceptions.finally_throws.Rethrowing.java:24)
        at exceptions.finally_throws.Rethrowing.main(exceptions.finally_throws.Rethrowing.java:35)
*///:~
