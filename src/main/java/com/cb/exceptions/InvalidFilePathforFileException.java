package com.cb.exceptions;

@SuppressWarnings("serial")
public class InvalidFilePathforFileException extends FrameworkException {

	public InvalidFilePathforFileException(String message) {
		super(message);
	}

	public InvalidFilePathforFileException(String message, Throwable e) {
		super(message, e);
	}
}
