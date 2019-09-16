package com.ace.SpringHibernetJPADemo.DaoImpl;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ace.SpringHibernetJPADemo.Dao.CustomerDao;
import com.ace.SpringHibernetJPADemo.entity.Customer;

@Repository

public class CustomerDaoImpl implements CustomerDao {
	
	

	@Autowired
	private  EntityManager em;

	@Override
	public void saveCustomer(Customer customer) {
		customer.setCreateDate(new Timestamp(new Date().getTime()));
		customer.setCustId(customer.getCustName() + customer.getMobileNumber().substring(2, 5));
		em.getTransaction().begin();

		em.persist(customer);
		em.getTransaction().commit();

	}

	@Override
	public Customer findByid(String custId) {
		Customer customer = null;
		
		customer = (Customer) em.createNamedQuery("findById").setParameter(1, custId).getSingleResult();
		
		return customer;
	}

	@Override
	public void updateCustomerMobile(Customer customer) {

		Customer cust = (Customer) em.createNamedQuery("findById").setParameter(1, customer.getCustId())
				.getSingleResult();
		// merge will put the cust object with unique id in persistence context
		// no two object with same id exist in persistence context
		em.merge(cust);
		em.getTransaction().begin();
		cust.setMobileNumber(customer.getMobileNumber());
		em.getTransaction().commit();
	}

	@Override
	public void deleteCustomer(String custId) {
		Customer customer = (Customer) em.createNamedQuery("findById").setParameter(1, custId).getSingleResult();
		em.merge(customer);
		em.getTransaction().begin();
		em.remove(customer);
		em.getTransaction().commit();

	}

}
