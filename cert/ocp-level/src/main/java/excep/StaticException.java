package excep;

import java.io.IOException;

public class StaticException {

	static {
		// throw new RuntimeException();   // Error:(5, 9) java: initializer must be able to complete normally
	}


	{
		// throw new RuntimeException();   // Error:(5, 9) java: initializer must be able to complete normally
	}


	public StaticException() throws IOException {

		// compiles fine
		throw new IOException();


		// OK
		// throw new RuntimeException();

	}
}
