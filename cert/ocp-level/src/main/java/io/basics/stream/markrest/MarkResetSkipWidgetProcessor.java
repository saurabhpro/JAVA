package io.basics.stream.markrest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * The first two values of the ByteArrayInputStream are read. Next, the markSupported() value is tested.
 * Since -1 is not one of the possible answers, we assume that ByteArrayInputStream does support marks.
 * <p>
 * Two values are read and three are skipped, but then reset() is called, putting the stream back in the state before mark() was called.
 * In other words, everything between mark() and reset() can be ignored.
 * <p>
 * The last value read is 3.”
 */

public class MarkResetSkipWidgetProcessor {
	public static void main(String... sprockets) throws Exception {
		final MarkResetSkipWidgetProcessor p = new MarkResetSkipWidgetProcessor();
		System.out.print(p.getWidgetNumber(new byte[]{1, 2, 3, 4, 5, 6, 7}));
	}

	private int getWidgetNumber(byte[] data) throws Exception {
		try (InputStream is = new ByteArrayInputStream(data)) {
			System.out.println(is.read(new byte[2]));

			if (!is.markSupported()) return -1;

			is.mark(5); // The <code>readAheadLimit</code> for this class has no meaning.

			System.out.println(is.read());
			System.out.println(is.read());
			System.out.println("Skipping : " + is.skip(3));

			is.reset();

			return is.read();
		}
	}
}