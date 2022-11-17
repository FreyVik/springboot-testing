package com.freyvik.springboot_testing.rest.app.handlers;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.freyvik.springboot_testing.rest.app.exceptions.NoOddException;
import com.freyvik.springboot_testing.rest.app.exceptions.ValidationRequestException;

@ControllerAdvice
public class CustomExceptionsHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, ?>> aritmeticException(ArithmeticException ex) {		
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("responseCode", 250);
		jsonResult.put("responseError", ex.getMessage());
		
		
		return new ResponseEntity<>(jsonResult.toMap(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidationRequestException.class)
	public ResponseEntity<Map<String, ?>> validationRequestException(ValidationRequestException ex) {	
		System.out.println("ValidationRequestException catched in custom handler");
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("responseCode", 240);
		jsonResult.put("responseError", ex.getMessage());
		jsonResult.put("badParams", ex.getErrorParams());
		
		
		return new ResponseEntity<>(jsonResult.toMap(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoOddException.class)
	public ResponseEntity<Map<String, ?>> NoOddException(NoOddException ex) {
		System.out.println("NoOddException catched in custom handler");
		
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("responseCode", 240);
		jsonResult.put("responseError", ex.getMessage());
		
		
		return new ResponseEntity<>(jsonResult.toMap(), HttpStatus.BAD_REQUEST);
	}
}
