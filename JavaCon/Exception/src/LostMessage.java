//: exceptions/LostMessage.java
// How an exception can be lost. Flaw in java Exception handling

/**
 * when try and finally generate exception , priority always goes to finally one
 */


public class LostMessage {
	/**
	 * even simpler way to lose an exception is just to return from inside a finally clause
	 * If you run this program you�ll see that it produces no output, even though an exception is thrown.
	 */
	static void ExceptionSilencer() {
		try {
			throw new RuntimeException();
		} finally {
			// Using 'return' inside the finally block
			// will silence any thrown exception.
			return;
		}
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();         //ex 1
			} finally {
				lm.dispose();   //ex 2
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	class VeryImportantException extends Exception {
		@Override
		public String toString() {
			return "A very important exception!";
		}
	}

	class HoHumException extends Exception {
		@Override
		public String toString() {
			return "A trivial exception";
		}
	}
} /* Output:
A trivial exception
*///:~