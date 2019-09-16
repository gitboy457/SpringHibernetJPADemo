package com.ace.SpringHibernetJPADemo.service;

import org.springframework.http.ResponseEntity;

import com.ace.SpringHibernetJPADemo.entity.Customer;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.ace.SpringHibernetJPADemo.request.DeleteCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerResponse;
import com.ace.SpringHibernetJPADemo.request.UpdateMobileRequest;

public interface CustomerService {
	
	public ResponseEntity<Object> save(CustomerRequest customerRequest);
	
	public ResponseEntity<Object> findById(FindCustomerRequest fcr);

	public ResponseEntity<Object> UpdateMobile(UpdateMobileRequest mobileRequest);
	
	public ResponseEntity<Object> deleteCustomer(DeleteCustomerRequest deleteCustomerRequest);
}
