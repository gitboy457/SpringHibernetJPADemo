package com.ace.SpringHibernetJPADemo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ace.SpringHibernetJPADemo.Dao.CustomerDao;
import com.ace.SpringHibernetJPADemo.entity.Customer;
import com.ace.SpringHibernetJPADemo.exception.ValidationException;
import com.ace.SpringHibernetJPADemo.mapper.CustomerMapper;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.ace.SpringHibernetJPADemo.request.DeleteCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerResponse;
import com.ace.SpringHibernetJPADemo.request.UpdateMobileRequest;
import com.ace.SpringHibernetJPADemo.service.CustomerService;
import com.ace.SpringHibernetJPADemo.validation.CustomerValidation;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public ResponseEntity<Object> save(CustomerRequest customerRequest) {

		Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
		customerDao.saveCustomer(customer);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> findById(FindCustomerRequest fcr) {

		String customerId= fcr.getCustomerId();
		Customer customer=customerDao.findByid(customerId);
		FindCustomerResponse customerresponse = customerMapper.customerToFindCustomerResponse(customer);
		ResponseEntity<Object> response= new ResponseEntity<>(customerresponse, HttpStatus.OK);	
		return response;
	}

	@Override
	public ResponseEntity<Object> UpdateMobile(UpdateMobileRequest mobileRequest) {
		Customer cust = new Customer();
		cust.setCustId(mobileRequest.getCustomerId());
		cust.setMobileNumber(mobileRequest.getMobile());
		customerDao.updateCustomerMobile(cust);
		ResponseEntity<Object> response= new ResponseEntity<>(HttpStatus.OK);
		return response;

	}

	@Override
	public ResponseEntity deleteCustomer(DeleteCustomerRequest deleteCustomerRequest) {
		customerDao.deleteCustomer(deleteCustomerRequest.getCustomerId());
		ResponseEntity<Object> response= new ResponseEntity<>(HttpStatus.OK);
		return response;
	}

}
