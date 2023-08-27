package com.goldilock.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> AllExcetionHandler(Exception e,WebRequest req){
		
		MyErrorDetails er= new MyErrorDetails();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage(e.getMessage());
		er.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> LoginExceptionHandler(LoginException e,WebRequest req){
		
		MyErrorDetails er= new MyErrorDetails();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage(e.getMessage());
		er.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> UserExceptionHandler(UserException e,WebRequest req){
		
		MyErrorDetails er= new MyErrorDetails();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage(e.getMessage());
		er.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
		

			MyErrorDetails er=new MyErrorDetails();
			er.setTimeStamp(LocalDateTime.now());
			er.setMessage(nfe.getMessage());
			er.setDetails(req.getDescription(false));
			
	return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
				
	}
	

}
