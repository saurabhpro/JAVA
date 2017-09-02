package pluralsight.testing.TDD.wrap;

import static java.lang.Integer.min;

/**
 * Created by saurabhkumar on 21/05/17.
 */
class WordWrap {
	static String wrap(final String inputLine, final int lineLength) {
		final StringBuilder builder = new StringBuilder();
		final int length = inputLine.length();

		builder.append(inputLine, 0, min(length, lineLength));

		int split = lineLength;

		while (length > split) {
			builder.append('\n');
			builder.append(inputLine, split, min(length, split + lineLength));
			split += lineLength;
		}

		return builder.toString();
	}
}
