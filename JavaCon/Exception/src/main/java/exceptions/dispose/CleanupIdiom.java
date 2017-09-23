/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
