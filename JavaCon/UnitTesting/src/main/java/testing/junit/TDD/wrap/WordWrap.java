package testing.junit.TDD.wrap;

import org.jetbrains.annotations.NotNull;

import static java.lang.Integer.min;

/**
 * Created by saurabhkumar on 21/05/17.
 */
class WordWrap {
	@NotNull
	static String wrap(final String inputLine, final int lineLength) {
		final StringBuilder accumulator = new StringBuilder();
		final int length = inputLine.length();

		accumulator.append(inputLine, 0, min(length, lineLength));

		int split = lineLength;

		while (length > split) {
			accumulator.append('\n');
			accumulator.append(inputLine, split, min(length, split + lineLength));
			split += lineLength;
		}

		return accumulator.toString();
	}
}
