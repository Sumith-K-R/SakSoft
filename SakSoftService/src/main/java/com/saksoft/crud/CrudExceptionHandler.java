package com.saksoft.crud;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saksoft.crud.model.GenericErrorResponse;
import com.saksoft.crud.model.UserNotFoundException;

//import org.springframework.context.annotation.Configuration;

@RestControllerAdvice
public class CrudExceptionHandler {
	
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> handler(UserNotFoundException e) {
		GenericErrorResponse Response= new GenericErrorResponse();
		Response.setDateTime(LocalDateTime.now());
		Response.setErrorCode("500");
		Response.setErrorMessage(e.getMessage());
		return new ResponseEntity<Object>(Response, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<Object> handler(NoSuchElementException e) {
		GenericErrorResponse Response= new GenericErrorResponse();
		Response.setDateTime(LocalDateTime.now());
		Response.setErrorCode("404");
		Response.setErrorMessage("User Not Found");
		return new ResponseEntity<Object>(Response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handler(MethodArgumentNotValidException e) {
		GenericErrorResponse Response= new GenericErrorResponse();
		Response.setDateTime(LocalDateTime.now());
		Response.setErrorCode("409");
		Response.setErrorMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		return new ResponseEntity<Object>(Response, HttpStatus.CONFLICT);
	}
	

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handler(Exception e) {
		GenericErrorResponse Response= new GenericErrorResponse();
		Response.setDateTime(LocalDateTime.now());
		Response.setErrorCode("500");
		Response.setErrorMessage(e.getMessage());
		return new ResponseEntity<Object>(Response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
