package com.ace.SpringHibernetJPADemo.exceptionHandler;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ace.SpringHibernetJPADemo.ServiceValidation.LogRequestResponse;
import com.ace.SpringHibernetJPADemo.exception.AuthenticationFailException;
import com.ace.SpringHibernetJPADemo.exception.AuthorizationFailException;
import com.ace.SpringHibernetJPADemo.exception.ErrorResponse;
import com.ace.SpringHibernetJPADemo.exception.ValidationException;

import ch.qos.logback.classic.Logger;

@ComponentScan
@RestControllerAdvice
public class CustomerExceptionHandler   {
	 private static final Logger logger =  (Logger) LoggerFactory.getLogger(CustomerExceptionHandler.class);
	@ExceptionHandler(value=Exception.class)
	public final ResponseEntity<Object> commonException(Exception ex){
		logger.error("error message ",ex);
		System.out.println(ex);
		System.out.println(":::::::::::::::::::::::::::");
		System.out.println(ex.getLocalizedMessage());
		System.out.println(":::::::::::::::::::::::::::");
		System.out.println(ex.toString());
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		ErrorResponse error= new ErrorResponse();
		error.setCurrentDate(new Date());
		error.setMessage("server error");
		error.setStatusCode(6000);
	    ResponseEntity<Object>	response =new ResponseEntity<Object>(error ,HttpStatus.OK);
		logRequestResponse.logResponse(response);
		return response;	
		
	}
	
	@ExceptionHandler(value=ValidationException.class)
	public final ResponseEntity<Object> validationExceptionHandler(ValidationException ex){
		logger.info("error message ",ex);
		System.out.println(ex);
		System.out.println(":::::::::::::::::::::::::::");
		System.out.println(ex.getLocalizedMessage());
		System.out.println(":::::::::::::::::::::::::::");
		System.out.println(ex.toString());
		ex.printStackTrace();
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		ErrorResponse error= new ErrorResponse();
		error.setCurrentDate(new Date());
		error.setMessage(ex.getMessage());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    ResponseEntity<Object>	response =new ResponseEntity<Object>(error ,HttpStatus.OK);
		logRequestResponse.logResponse(response);
		return response;
		
	}
	
	
	@ExceptionHandler(value=AuthenticationFailException.class)
	public final ResponseEntity<Object> AuthenticationFailExceptionHandler(AuthenticationFailException ex){
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		ErrorResponse error= new ErrorResponse();
		error.setCurrentDate(new Date());
		error.setMessage(ex.getMessage());
		error.setStatusCode(500);
		ResponseEntity<Object>	response =new ResponseEntity<Object>(error ,HttpStatus.OK);
		logRequestResponse.logResponse(response);
		return response;
		
	}
	
	@ExceptionHandler(value=AuthorizationFailException.class)
	public final ResponseEntity<Object> AuthorizationFailExceptionHandler(AuthorizationFailException ex){
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		ErrorResponse error= new ErrorResponse();
		error.setCurrentDate(new Date());
		error.setMessage(ex.getMessage());
		error.setStatusCode(501);
		ResponseEntity<Object>	response =new ResponseEntity<Object>(error ,HttpStatus.OK);
		logRequestResponse.logResponse(response);
		return response;
		
	}

}
