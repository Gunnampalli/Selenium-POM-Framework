package com.cb.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameworkException {

	public BrowserInvocationFailedException(String message) {
		super(message);
	}

	public BrowserInvocationFailedException(String message, Throwable e) {
		super(message, e);
	}

}
