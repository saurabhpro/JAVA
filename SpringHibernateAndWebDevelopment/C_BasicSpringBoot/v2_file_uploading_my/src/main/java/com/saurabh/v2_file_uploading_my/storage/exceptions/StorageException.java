package com.saurabh.v2_file_uploading_my.storage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class StorageException extends RuntimeException {


	private static final String MESSAGE = "File couldn't be accessed due to some unknown issue";

	public StorageException() {
		this(MESSAGE);
	}

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
