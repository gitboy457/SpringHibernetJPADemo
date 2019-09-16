package com.ace.SpringHibernetJPADemo.security;

import javax.servlet.http.HttpServletRequest;

import com.ace.SpringHibernetJPADemo.request.CustomerRequest;

public interface CustomerAuthorization {
	public void doAuthorization(Object Request, HttpServletRequest request);

}
