package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {


	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception ex){
		
		ErrorInfo error=new ErrorInfo();
		error.setMsg(ex.getMessage());
//		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		//error.setErrorCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(error,HttpStatus.CREATED);
		
	}
}
