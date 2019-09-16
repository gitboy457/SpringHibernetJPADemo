package com.ace.SpringHibernetJPADemo.mapper;

import com.ace.SpringHibernetJPADemo.entity.Customer;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.ace.SpringHibernetJPADemo.request.FindCustomerResponse;

public interface CustomerMapper {
	
	Customer customerRequestToCustomer(CustomerRequest customerRequest);
	
	FindCustomerResponse customerToFindCustomerResponse(Customer customer);

}
