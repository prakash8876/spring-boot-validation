package com.demp.app.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demp.app.exception.UserNotFoundException;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult()
			.getFieldErrors()
			.forEach(error -> {
				errorMap.put(error.getField(), error.getDefaultMessage());
			});
		return errorMap;
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleUserNotFoundException(UserNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error Message", ex.getMessage());
		return errorMap;
	}
	
	
}
