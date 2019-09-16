package com.ace.SpringHibernetJPADemo.exception;

public class AuthenticationFailException extends RuntimeException {
	
	public AuthenticationFailException(String msg) {
	super(msg);
	}

}
