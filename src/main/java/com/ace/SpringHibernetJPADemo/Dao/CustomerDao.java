package com.ace.SpringHibernetJPADemo.Dao;

import com.ace.SpringHibernetJPADemo.entity.Customer;

public interface CustomerDao {
	
	public void saveCustomer(Customer customer);
	
	public Customer findByid(String custId);
	
	public void updateCustomerMobile(Customer customer);
	
	public void deleteCustomer(String custId);
	
	
	
	

}
