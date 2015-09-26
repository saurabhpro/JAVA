import java.util.ConcurrentModificationException;

import static java.lang.System.exit;
import static java.lang.System.out;

/**
 * Created by Saurabh on 8/23/2015.
 */
public class ReturnFinally {
    static int count;

    static Exception Ret() {
        try {
            throw new NoSuchFieldException();
        } catch (Exception e) {
            try {
                return new NullPointerException();
            } finally {
                return new ClassCastException();
            }

        } finally {
            return new ConcurrentModificationException();       //overrides all return statements
        }
    }

    static void finallyAlwaysRuns() {
        while (true) {
            try {
                // Post-increment is zero first time:
                if (count++ == 0)
                    throw new ArithmeticException();
                System.out.println("No exception");
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) break; // out of "while"
            }
        }
    }

    public static void main(String[] args) {
        out.println(Ret());

        System.out.println("\nCheck if finally always runs\n");
        finallyAlwaysRuns();

        exit(5);        //simply shows exit status as 5
    }
}
