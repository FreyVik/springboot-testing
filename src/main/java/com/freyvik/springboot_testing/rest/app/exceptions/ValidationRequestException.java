package com.freyvik.springboot_testing.rest.app.exceptions;

import org.json.JSONArray;

public class ValidationRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private JSONArray errorParams;

	public ValidationRequestException(String message, JSONArray params) {
		super(message);
		this.errorParams =  params;
	}
	
	public JSONArray getErrorParams() {
		return this.errorParams;
	}
}
