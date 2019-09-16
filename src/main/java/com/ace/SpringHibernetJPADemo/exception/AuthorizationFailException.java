package com.ace.SpringHibernetJPADemo.exception;

public class AuthorizationFailException extends RuntimeException {
	
	public AuthorizationFailException(String msg) {
		super(msg);
	}

}
