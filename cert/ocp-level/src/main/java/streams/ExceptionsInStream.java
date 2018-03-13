package streams;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

class ExceptionCaseStudy {
	static List<String> create() throws IOException {
		throw new IOException();
	}
}

class ExceptionsInStream {

	public static void main(String[] args) {
		// ExceptionCaseStudy.create().stream().count(); // won't compile <code>unhandled exception type IOException
		// he lambda to which this method reference expands does declare an exception. The Supplier interface does not allow checked exceptions.

		// approach 1
		Supplier<List<String>> s = () -> {
			try {
				return ExceptionCaseStudy.create();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};


	}

	// approach 2
	private static List<String> createSafe() {
		try {
			return ExceptionCaseStudy.create();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
