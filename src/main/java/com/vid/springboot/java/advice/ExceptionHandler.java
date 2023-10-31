package com.vid.springboot.java.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vid.springboot.java.Exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			errorMap.put(error.getObjectName(), error.getDefaultMessage());
		});
		return errorMap;
		
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handlerBusinessException(UserNotFoundException userNotFoundException){
	Map<String,String> errorMap=new HashMap<>();
	errorMap.put("errorMessage", userNotFoundException.getMessage());
	return errorMap;
}
}