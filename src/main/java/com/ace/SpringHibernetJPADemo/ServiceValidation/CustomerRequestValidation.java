package com.ace.SpringHibernetJPADemo.ServiceValidation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.ace.SpringHibernetJPADemo.request.DeleteCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerResponse;
import com.ace.SpringHibernetJPADemo.request.UpdateMobileRequest;

public interface CustomerRequestValidation {

	public ResponseEntity<Object> save(CustomerRequest customerRequest  ,HttpServletRequest request);
	
	public ResponseEntity<Object> findById(FindCustomerRequest fcr,HttpServletRequest request);

	public ResponseEntity<Object> UpdateMobile(UpdateMobileRequest mobileRequest,HttpServletRequest request);
	
	public ResponseEntity<Object> deleteCustomer(DeleteCustomerRequest deleteCustomerRequest,HttpServletRequest request);
}
