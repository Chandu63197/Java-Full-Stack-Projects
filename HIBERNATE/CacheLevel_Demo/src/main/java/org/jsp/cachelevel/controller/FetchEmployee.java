package org.jsp.cachelevel.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.cachelevel.dto.Employee;

public class FetchEmployee {
   public static void main(String[] args) {
	 EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	 EntityManager manager1=factory.createEntityManager();
	 EntityManager manager2=factory.createEntityManager();
  	 Employee e1=manager1.find(Employee.class, 2);
  	 Employee e2=manager1.find(Employee.class, 1);
  	 Employee e3=manager1.find(Employee.class, 1);
  	 Employee e4=manager1.find(Employee.class, 2);
  	 Employee e5=manager1.find(Employee.class, 2);
   }
}
