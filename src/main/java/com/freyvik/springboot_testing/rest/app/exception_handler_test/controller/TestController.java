package com.freyvik.springboot_testing.rest.app.exception_handler_test.controller;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freyvik.springboot_testing.rest.app.exceptions.NoOddException;
import com.freyvik.springboot_testing.rest.app.exceptions.ValidationRequestException;

@RestController
@RequestMapping(("/handlerErrorTest"))
public class TestController {
	
	@GetMapping(value = "/isOdd", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> noOddTest(@RequestBody HashMap<String, ?> jsonRequest) {
		JSONObject jsonResponse = new JSONObject();
		
		validateRequest(jsonRequest);
		
		return new ResponseEntity<>(jsonResponse.put("responseCode", 0).toMap(), HttpStatus.OK);
	}
	
	@GetMapping("/aritmethicError")
	public ResponseEntity<?> aritmeticError() {
		
		Integer division = 100/0;
		
		return new ResponseEntity<>(new JSONObject().put("divisionResult", division).toMap(), HttpStatus.OK);
	}
	
	private HashMap<String, ?> validateRequest(HashMap<String, ?> jsonRequest) {
		if (jsonRequest.get("number") instanceof Integer == false) {
			throw new ValidationRequestException("parameterType not suported", new JSONArray().put("number"));
		}
		
		Integer requestNumber = (Integer) jsonRequest.get("number");
		
		if (requestNumber % 2 != 0) {
			throw new NoOddException();
		}
		
		return jsonRequest;
	}
}
