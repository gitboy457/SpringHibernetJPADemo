package com.ace.SpringHibernetJPADemo.ServiceValidation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.ace.SpringHibernetJPADemo.entity.Customer;
import com.ace.SpringHibernetJPADemo.exception.ValidationException;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.ace.SpringHibernetJPADemo.request.DeleteCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerResponse;
import com.ace.SpringHibernetJPADemo.request.UpdateMobileRequest;
import com.ace.SpringHibernetJPADemo.security.CustomerAuthentication;
import com.ace.SpringHibernetJPADemo.security.CustomerAuthorization;
import com.ace.SpringHibernetJPADemo.service.CustomerService;
import com.ace.SpringHibernetJPADemo.validation.CustomerValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Component
@RequestScope
public class CustomerRequestValidationImpl implements CustomerRequestValidation {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerAuthentication customerAuthentication;

	@Autowired
	private CustomerAuthorization customerAuthorization;

	@Override
	public ResponseEntity<Object> save(CustomerRequest customerRequest, HttpServletRequest request) {
		// logging of request
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		logRequestResponse.logRequest(customerRequest, request);

		// we can even do here authentication and autherization here
		customerAuthentication.doAuthentication(customerRequest, request);
		customerAuthorization.doAuthorization(customerRequest, request);

		// do validation here before sending request to service layer
		if (CustomerValidation.validateCustomerRequest(customerRequest)) {

			// if request validate successfully then call service layer

			ResponseEntity<Object> response = customerService.save(customerRequest);
			// logging of response
			logRequestResponse.logResponse(response);
			return response;
		}
		throw new ValidationException("validation error");
	}

	@Override
	public ResponseEntity<Object> findById(FindCustomerRequest fcr, HttpServletRequest request) {
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		// logging of request
		 logRequestResponse.logRequest(fcr, request);

		// we can even do here authentication and autherization here
			customerAuthentication.doAuthentication(fcr, request);
			customerAuthorization.doAuthorization(fcr, request);
			
			// do validation here before sending request to service layer
		ResponseEntity<Object> response = customerService.findById(fcr);

		// logging of response
		logRequestResponse.logResponse(response);
		return response;
	}

	@Override
	public ResponseEntity<Object> UpdateMobile(UpdateMobileRequest mobileRequest,HttpServletRequest request) {
		ResponseEntity<Object>  response =null;
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		// logging of request
		 logRequestResponse.logRequest(mobileRequest, request);

		// we can even do here authentication and autherization here
			customerAuthentication.doAuthentication(mobileRequest, request);
			customerAuthorization.doAuthorization(mobileRequest, request);
			// do validation here before sending request to service layer
			if(CustomerValidation.validateMobile(mobileRequest.getMobile())) {
			
				response=customerService.UpdateMobile(mobileRequest);
				// logging of response
				logRequestResponse.logResponse(response);
				return response;
			}
			
			
			throw new ValidationException("validation error");

	}

	@Override
	public ResponseEntity<Object> deleteCustomer(DeleteCustomerRequest deleteCustomerRequest,HttpServletRequest request) {
		LogRequestResponse logRequestResponse = new LogRequestResponse();
		// logging of request
		 logRequestResponse.logRequest(deleteCustomerRequest, request);

		// we can even do here authentication and autherization here
			customerAuthentication.doAuthentication(deleteCustomerRequest, request);
			customerAuthorization.doAuthorization(deleteCustomerRequest, request);
			
			// do validation here before sending request to service layer
			ResponseEntity<Object> response=customerService.deleteCustomer(deleteCustomerRequest);
			//logging of response
			logRequestResponse.logResponse(response);
		return response;

	}

}
