package excep;

public class Bells {
	public static void main(String[] notes) throws Throwable {
		try (Player p = null) {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("hi");
		} catch (Error e) {
			System.out.println("err");
		}
	}

	class Player implements AutoCloseable {
		@Override
		public void close() throws RingException {
		}
	}

	class RingException extends Exception {
		public RingException(String message) {
		}
	}
}


class Cliff {
	public static void main(String... rocks) {
		try {
			new Cliff().climb();
		} catch (Throwable t) {
			System.out.println(t); // java.lang.RuntimeException
		}
	}

	private final void climb() throws Exception {
		try (HikingGear gear = new HikingGear()) {
			throw new RuntimeException();
		}
	}

	final class FallenException extends Exception {
	}

	final class HikingGear implements AutoCloseable {
		@Override
		public void close() throws Exception {
			throw new FallenException();
		}
	}
}

// “a class must inherit from RuntimeException or Error to be considered an unchecked exception.”