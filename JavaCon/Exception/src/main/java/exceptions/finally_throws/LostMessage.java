package exceptions.finally_throws;//: exceptions/exceptions.finally_throws.LostMessage.java
// How an exception can be lost. Flaw in java Exception handling

/**
 * when try and finally generate exception , priority always goes to finally one
 */


public class LostMessage {
	/**
	 * even simpler way to lose an exception is just to return from inside a finally clause
	 * If you run this program you'll see that it produces no output, even though an exception is thrown.
	 */
	@SuppressWarnings("ReturnInsideFinallyBlock")
	private static void ExceptionSilencer() {
		//noinspection finally
		try {
			throw new RuntimeException();
		} finally {
			// Using 'return' inside the finally block
			// will silence any thrown exception.
			//works even in java 9 - intellij thinks its unnecessary
			//noinspection UnnecessaryReturnStatement
			return;
		}
	}

	public static void main(String[] args) {
		try {
			LostMessage.ExceptionSilencer();

			LostMessage lm = new LostMessage();
			try {
				lm.f();         //ex 1
			} finally {
				lm.dispose();   //ex 2
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	private void dispose() throws HoHumException {
		throw new HoHumException();
	}

	class VeryImportantException extends Exception {
		@Override
		public String toString() {
			return "exceptions.try_with_resources.A very important exception!";
		}
	}

	class HoHumException extends Exception {
		@Override
		public String toString() {
			return "exceptions.try_with_resources.A trivial exception";
		}
	}
} /* Output:
exceptions.try_with_resources.A trivial exception
*///:~