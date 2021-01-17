package com.java.guice.dependency.injection.exception;

public class LoggingException extends RuntimeException {
	public LoggingException(Exception e) {
		super(e);
	}
}
