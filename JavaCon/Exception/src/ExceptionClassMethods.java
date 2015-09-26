/**
 * Created by Saurabh on 9/25/2015.
 */

/**
 * the keyword throw produces exception object on the heap with new throw(...) keyword.
 * the current path of execution is TERMINATED** and the reference for the exception
 * object is returned/ejected from the current context.
 * <p>
 * Now the exception handler mechanism takes charge whose job is to recover from the problem.
 */

public class ExceptionClassMethods {

    static class StackTrace {
        static void f() {
            // Generate an exception to fill in the stack trace
            try {
                throw new Exception();
            } catch (Exception e) {
                for (StackTraceElement ste : e.getStackTrace())
                    System.out.println(ste.getMethodName());
            }
        }

        static void g() {
            f();
        }

        static void h() {
            g();
        }

        void stackTrace() {
            f();
            System.out.println("--------------------------------");
            g();
            System.out.println("--------------------------------");
            h();
            System.out.println("--------------------------------");
        }
    }


    public static void main(String[] args) {
        ExceptionClassMethods.StackTrace trace = new ExceptionClassMethods.StackTrace();
        trace.stackTrace();


        //More Methods
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }

        System.out.println("Can you reach here - YESS");
    }
}
