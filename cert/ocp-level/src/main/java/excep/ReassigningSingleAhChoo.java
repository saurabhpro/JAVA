package excep;

public class ReassigningSingleAhChoo {
	public static void main(String[] args) throws SneezeException {
		try {
			throw new SneezeException();
		} catch (SneezeException e) {
			// e = new RuntimeException(); // Since a single exception type is caught, only the same type of exception or a sub- class is allowed to be assigned to the variable in the catch block.
			throw e;
		}
	}

	static class SneezeException extends Exception {
	}

	static class SniffleException extends SneezeException {
	}
}