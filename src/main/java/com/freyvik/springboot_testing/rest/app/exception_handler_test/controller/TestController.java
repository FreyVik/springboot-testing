package com.freyvik.springboot_testing.rest.app.exception_handler_test.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/handlerErrorTest"))
public class TestController {
	
	@GetMapping(value = "/noOdd", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> noOddTest(@RequestBody HashMap<String, ?> jsonRequest) {
		JSONObject jsonResponse = new JSONObject();
		
		System.out.println("Entry noOdd test\n number: " + jsonRequest.get("number"));
		
		return new ResponseEntity<>(jsonResponse.put("responseCode", 0).toMap(), HttpStatus.OK);
	}
}
