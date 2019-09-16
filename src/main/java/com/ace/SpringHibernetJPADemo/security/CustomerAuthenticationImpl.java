package com.ace.SpringHibernetJPADemo.security;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.ace.SpringHibernetJPADemo.exception.AuthenticationFailException;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;

@Component
@RequestScope
public class CustomerAuthenticationImpl implements CustomerAuthentication {

	

	@Override
	public void doAuthentication(Object Request, HttpServletRequest request) {
		
		System.out.println("authentication not done ");
		 if(false) {
		 throw new AuthenticationFailException("incorrect credentials");
		 }
	}

}
