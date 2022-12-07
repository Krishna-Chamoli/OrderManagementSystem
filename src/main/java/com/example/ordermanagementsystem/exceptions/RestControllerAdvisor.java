package com.example.ordermanagementsystem.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleCustomerNotFoundException(CustomerNotFoundException cnfe) {
		Map<String, String> response = new HashMap<>();
		response.put("message", cnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
