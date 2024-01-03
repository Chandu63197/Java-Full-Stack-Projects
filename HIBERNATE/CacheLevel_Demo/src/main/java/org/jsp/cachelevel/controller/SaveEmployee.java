package org.jsp.cachelevel.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.cachelevel.dto.Employee;

public class SaveEmployee {
   public static void main(String[] args) {
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 EntityTransaction transaction=manager.getTransaction();
	 Employee e=new Employee();
	 e.setName("ABC");
	 e.setPhone(998877);
	 e.setEmail("abc@gmail.com");
	 e.setPassword("abc123");
	 manager.persist(e);
	 transaction.begin();
	 transaction.commit();
	 System.out.println("Employee saved with:"+e.getId());
   }
}
