package sybex.ch06;

public class JammedTurkeyCage implements AutoCloseable {

	public static void main(String[] args) {
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new IllegalStateException("turkeys ran off");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
			for (Throwable t : e.getSuppressed())
				System.out.println(t.getMessage());
		}


		try (JammedTurkeyCage t1 = new JammedTurkeyCage(); JammedTurkeyCage t2 = new JammedTurkeyCage()) {
			System.out.println("turkeys entered cages");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
			for (Throwable t : e.getSuppressed())
				System.out.println(t.getMessage());
		}
	}

	public void close() throws IllegalStateException {
		throw new IllegalStateException("Cage door does not close");
	}
}