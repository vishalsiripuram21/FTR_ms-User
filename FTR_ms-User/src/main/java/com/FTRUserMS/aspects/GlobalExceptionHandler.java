package com.FTRUserMS.aspects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.FTRUserMS.CustomExceptions.CustomException;
import com.FTRUserMS.CustomExceptions.USER_ALREADY_EXIST;
import com.FTRUserMS.CustomExceptions.USER_NOT_FOUND;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Value("${general.exception}")
	public String generalException;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> validationException(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Map<String,String>> handleConstraintViolation(
	  ConstraintViolationException ex, WebRequest request) {
	    Map<String,String> errors = new HashMap<String,String>();
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	    	String path = violation.getPropertyPath()+"";
	    	String message = violation.getMessage();
	        errors.put(
	  	          path,message );
	    }
	    return new ResponseEntity<>(errors,new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(USER_ALREADY_EXIST.class)
	public ResponseEntity<Map<String,String>> userExisting(USER_ALREADY_EXIST ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("ErrorMessage :", ex.getMessage());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Map<String,String>> userExisting(HttpRequestMethodNotSupportedException ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("ErrorMessage :", generalException);
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(USER_NOT_FOUND.class)
	public ResponseEntity<Map<String,String>> userNotFound(USER_NOT_FOUND ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("ErrorMessage :", ex.getMessage());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Map<String,String>> userNotFound(CustomException ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("ErrorMessage :", ex.getMessage());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> exception(Exception ex){
//		return new ResponseEntity<>(generalException,HttpStatus.BAD_REQUEST);
//	}
}
