package com.example.rakesh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseMessage> StudentNotFoundHandler(Exception e){
		ResponseMessage mesg = new ResponseMessage();
		mesg.setMessage(e.getMessage());
		mesg.setErrorCode(404);
       return new ResponseEntity<>(mesg, HttpStatus.CREATED);
//	   return ResponseEntity.ok(mesg);
	}
	
	

}
