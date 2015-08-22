import java.util.ConcurrentModificationException;

import static java.lang.System.exit;
import static java.lang.System.out;

/**
 * Created by Saurabh on 8/23/2015.
 */
public class ReturnFinally {

    public static void main(String[] args) {
        out.println(Ret());
        exit(5);        //simply shows exit status as 5
    }

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
}
