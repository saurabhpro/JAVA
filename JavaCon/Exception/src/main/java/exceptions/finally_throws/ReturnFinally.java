package exceptions.finally_throws;

import java.util.ConcurrentModificationException;

import static java.lang.System.exit;
import static java.lang.System.out;

/**
 * Created by Saurabh on 8/23/2015.
 */
public class ReturnFinally {
	private static int count;

	private static Exception Ret() {
		//noinspection finally
		try {
			throw new NoSuchFieldException();
		} catch (Exception e) {
			//noinspection finally
			try {
				return new NullPointerException();
			} finally {
				//noinspection ReturnInsideFinallyBlock
				return new ClassCastException();
			}

		} finally {
			//noinspection ReturnInsideFinallyBlock
			return new ConcurrentModificationException();       //overrides all return statements
		}
	}

	private static void finallyAlwaysRuns() {
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
				if (count == 2) //noinspection ContinueOrBreakFromFinallyBlock
					break; // out of "while"
			}
		}
	}

	public static void main(String[] args) {
		out.println(Ret().toString());

		System.out.println("\nCheck if finally always runs\n");
		finallyAlwaysRuns();

		exit(5);        //simply shows exit status as 5
	}
}
