package com.ace.SpringHibernetJPADemo.exception;

import org.springframework.stereotype.Component;

//@Component
public class ValidationException extends RuntimeException {
	
	public ValidationException( String msg ) {
		super(msg);
	
	}

}
