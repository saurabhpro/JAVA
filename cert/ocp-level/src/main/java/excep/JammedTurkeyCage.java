package excep;

public class JammedTurkeyCage implements AutoCloseable {

	public static void main(String[] args) throws InterruptedException {
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new IllegalStateException("turkeys ran off");
		} catch (IllegalStateException e) {
			System.err.println("caught: " + e.getMessage());
			for (Throwable t : e.getSuppressed())
				System.err.println("suppressed: " + t.getMessage());
		}

		Thread.sleep(1000);

		try (JammedTurkeyCage t1 = new JammedTurkeyCage();
		     JammedTurkeyCage t2 = new JammedTurkeyCage()) {
			System.out.println("turkeys entered cages");
		} catch (IllegalStateException e) {
			System.err.println("caught for t2: " + e.getMessage());
			for (Throwable t : e.getSuppressed())
				System.err.println(t.getMessage() + " for t1");
		}


		Thread.sleep(1000);

		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new RuntimeException("turkeys ran off");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
		}
	}

	@Override
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Cage door does not close");
	}
}