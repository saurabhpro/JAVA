//: exceptions/Rethrowing.java
// Demonstrating fillInStackTrace()

public class Rethrowing {
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
		//this string argument  doesn't get printed unless stacktrace called in catch block of callee
	}

	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside g(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}

	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside h(),e.printStackTrace()");
			e.printStackTrace(System.out);

			throw (Exception) e.fillInStackTrace();

			/**Records information within this Throwable object about the current state of the stack frames.
			 * Useful when an application is rethrowing an error or exception
			 *
			 * If you simply rethrow the current exception, the information that you print about that exception
			 * in printStackTrace( ) will pertain to the exception�s origin, not the place where you rethrow it.
			 *
			 * If you want to install new stack trace information, you can do so by calling fillInStackTrace( ),
			 * which returns a Throwable object that it creates by stuffing the current stack information
			 * into the old exception object.
			 */
		}
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		    /*
            java.lang.Exception: thrown from f()
            at Rethrowing.f(Rethrowing.java:7)
            at Rethrowing.h(Rethrowing.java:23)
            at Rethrowing.main(Rethrowing.java:53)
             */
		}

		System.out.println("\nNow see the difference when fillinStackTrace is called\n");

		try {
			h();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
	        /*
            java.lang.Exception: thrown from f()
            at Rethrowing.h(Rethrowing.java:23)
            at Rethrowing.main(Rethrowing.java:53)
             */
		}
	}
} /* Output:
originating the exception in f()
Inside g(),e.printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.f(Rethrowing.java:7)
        at Rethrowing.g(Rethrowing.java:11)
        at Rethrowing.main(Rethrowing.java:29)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.f(Rethrowing.java:7)
        at Rethrowing.g(Rethrowing.java:11)
        at Rethrowing.main(Rethrowing.java:29)
originating the exception in f()
Inside h(),e.printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.f(Rethrowing.java:7)
        at Rethrowing.h(Rethrowing.java:20)
        at Rethrowing.main(Rethrowing.java:35)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.h(Rethrowing.java:24)
        at Rethrowing.main(Rethrowing.java:35)
*///:~
