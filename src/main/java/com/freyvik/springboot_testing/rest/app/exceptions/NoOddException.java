package com.freyvik.springboot_testing.rest.app.exceptions;

public class NoOddException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoOddException() {
		super("Used number is not an odd");
	}
}
