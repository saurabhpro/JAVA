package exceptions.dispose;

// Each disposable object must be followed by a try-finally
class NeedsCleanup { // Construction can't fail
	private static long counter = 1;
	private final long id = counter++;

	void dispose() {
		System.out.println("exceptions.dispose.NeedsCleanup " + id + " disposed");
	}
}

class ConstructionException extends Exception {
}

class NeedsCleanup2 extends NeedsCleanup {
	// Construction can fail:
	NeedsCleanup2() throws ConstructionException {
	}
}

public class CleanupIdiom {
	public static void main(String[] args) {
		// Section 1:
		NeedsCleanup nc1 = new NeedsCleanup();

		//noinspection EmptyTryBlock
		try {
			// ...
		} finally {
			nc1.dispose();
		}

		// Section 2:
		// If construction cannot fail you can group objects:
		NeedsCleanup nc2 = new NeedsCleanup();
		NeedsCleanup nc3 = new NeedsCleanup();

		//noinspection EmptyTryBlock
		try {
			// ...
		} finally {
			nc3.dispose(); // Reverse order of construction
			nc2.dispose();
		}

		// Section 3:
		// If construction can fail you must guard each one:
		try {
			NeedsCleanup2 nc4 = new NeedsCleanup2();
			try {
				NeedsCleanup2 nc5 = new NeedsCleanup2();

				//noinspection EmptyTryBlock
				try {
					// ...
				} finally {
					nc5.dispose();
				}
			} catch (ConstructionException e) { // nc5 constructor
				System.out.println(e.toString());
			} finally {
				nc4.dispose();
			}
		} catch (ConstructionException e) { // nc4 constructor
			System.out.println("message : " + e.getMessage());
		}
	}
} /* Output:
exceptions.dispose.NeedsCleanup 1 disposed
exceptions.dispose.NeedsCleanup 3 disposed
exceptions.dispose.NeedsCleanup 2 disposed
exceptions.dispose.NeedsCleanup 5 disposed
exceptions.dispose.NeedsCleanup 4 disposed
*///:~
