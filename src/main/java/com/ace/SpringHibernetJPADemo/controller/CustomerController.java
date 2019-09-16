package com.ace.SpringHibernetJPADemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ace.SpringHibernetJPADemo.ServiceValidation.CustomerRequestValidation;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.ace.SpringHibernetJPADemo.request.DeleteCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerResponse;
import com.ace.SpringHibernetJPADemo.request.UpdateMobileRequest;
import com.ace.SpringHibernetJPADemo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	
	@Autowired
	private CustomerRequestValidation customerRequestValidation;

	
	//all the http request method is post as per security concern
	//all the data we required inside the body in json formate
	
	
	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveCustomer(@RequestBody CustomerRequest customerRequest,HttpServletRequest request) {
		return customerRequestValidation.save(customerRequest,request);

	}

	@PostMapping(value = "/findCustomer")
	public ResponseEntity<Object> findCustomer(@RequestBody FindCustomerRequest fcr,HttpServletRequest request) {

		return customerRequestValidation.findById(fcr,request);
	}

	@PostMapping(value = "/updateCustomerMobile")
	public ResponseEntity<Object> updateCustomerMobile(@RequestBody UpdateMobileRequest mobileRequest,HttpServletRequest request) {

		return customerRequestValidation.UpdateMobile(mobileRequest ,request);

	}

	@PostMapping(value = "/deleteCustomer")
	public ResponseEntity<Object> deleteCustomer(@RequestBody DeleteCustomerRequest deleteCustomerRequest,HttpServletRequest request) {

		return customerRequestValidation.deleteCustomer(deleteCustomerRequest,request);

	}
}
