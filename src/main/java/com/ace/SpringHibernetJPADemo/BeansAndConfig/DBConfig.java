package com.ace.SpringHibernetJPADemo.BeansAndConfig;

import javax.persistence.EntityManager;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;






@Configuration
public class DBConfig {
	
	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerPersistence");
		return emf;
	}
	
	@Bean
	public EntityManager getEntityManager() {
		EntityManager em=getEntityManagerFactory().createEntityManager();
		return em;
	}

        
	
}
