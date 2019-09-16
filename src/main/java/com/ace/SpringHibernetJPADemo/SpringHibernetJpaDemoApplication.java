package com.ace.SpringHibernetJPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ace.SpringHibernetJPADemo.entity.Customer;

@SpringBootApplication
public class SpringHibernetJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernetJpaDemoApplication.class, args);
		
		
		/*EntityManagerFactory emf=Persistence.createEntityManagerFactory("CustomerPersistence");
		EntityManager em=emf.createEntityManager();
		Customer cust=em.find(Customer.class, 1);
		System.out.println(cust.getCustName() +"..."+cust.getId());*/
	}

}
