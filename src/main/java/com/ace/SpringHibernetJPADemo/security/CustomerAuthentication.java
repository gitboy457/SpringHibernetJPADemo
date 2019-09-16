package com.ace.SpringHibernetJPADemo.security;

import javax.servlet.http.HttpServletRequest;

import com.ace.SpringHibernetJPADemo.request.CustomerRequest;

public interface CustomerAuthentication {

	public void doAuthentication(Object Request,HttpServletRequest request);
}
