package com.ace.SpringHibernetJPADemo.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.ace.SpringHibernetJPADemo.exception.AuthorizationFailException;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;

@Component
@RequestScope
public class CustomerAuthorizationImpl implements CustomerAuthorization {

	@Override
	public void doAuthorization(Object Request, HttpServletRequest request) {
		
		System.out.println("authorization not done ");
		if(false) {
			throw new AuthorizationFailException("Unauthorized user");
		}

		
	}

}
