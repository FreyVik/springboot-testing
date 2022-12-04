package com.freyvik.springboot_testing.app.exception_handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerInvalidArgument(MethodArgumentNotValidException ex) {
		System.out.println("Custom handler");
		Map<String, String> errorMap = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		Map<String, Object> errorResult = new HashMap<>();
		errorResult.put("faultString", "Request validatioin");
		errorResult.put("faultCode", 400);
		errorResult.put("badParams", errorMap);
		
		return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
	}
}
