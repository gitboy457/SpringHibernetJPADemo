package com.ace.SpringHibernetJPADemo.mapper;

import org.springframework.stereotype.Component;

import com.ace.SpringHibernetJPADemo.entity.Customer;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerResponse;
@Component
public class CustomerMapperImpl implements CustomerMapper {

	@Override
	public Customer customerRequestToCustomer(CustomerRequest customerRequest) {
		Customer customer=new Customer();
		
		customer.setCustName(customerRequest.getCustName());
		customer.setEmailAddress(customerRequest.getEmailAddress());
		customer.setMobileNumber(customerRequest.getMobileNumber());
		return customer;
	}

	@Override
	public FindCustomerResponse customerToFindCustomerResponse(Customer customer) {
		 FindCustomerResponse fcr=new FindCustomerResponse();
		 fcr.setCustId(customer.getCustId());
		 fcr.setCustName(customer.getCustName());
		 fcr.setEmailAddress(customer.getEmailAddress());
		 fcr.setMobileNumber(customer.getMobileNumber());
		 fcr.setCreateDate(customer.getCreateDate());
		return fcr;
	}

}
