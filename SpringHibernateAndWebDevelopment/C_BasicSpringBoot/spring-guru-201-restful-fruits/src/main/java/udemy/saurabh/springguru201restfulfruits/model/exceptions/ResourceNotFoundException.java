package udemy.saurabh.springguru201restfulfruits.model.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final String MESSAGE = "Resource Not Found";

	public ResourceNotFoundException() {
		super(MESSAGE);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}