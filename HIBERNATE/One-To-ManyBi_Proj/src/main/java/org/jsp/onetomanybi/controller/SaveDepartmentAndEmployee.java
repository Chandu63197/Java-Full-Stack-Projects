package org.jsp.onetomanybi.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;

public class SaveDepartmentAndEmployee {
   public static void main(String[] args) {
	   Department d=new Department();
	   d.setName("Developer");
	   d.setLocation("Bangalore");
	   
	   Employee e1=new Employee();
	   e1.setName("ABC");
	   e1.setDesg("CEO");
	   e1.setSalary(98765);
	   e1.setDept(d);
	   
	   Employee e2=new Employee();
	   e2.setName("Rohan");
	   e2.setDesg("Scientist");
	   e2.setSalary(987665);
	   e2.setDept(d);
	   
	   Employee e3=new Employee();
	   e3.setName("Bahubali");
	   e3.setDesg("Soldier");
	   e3.setSalary(98765);
	   e3.setDept(d);
	   
	   d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));
	   EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	   EntityTransaction transaction=manager.getTransaction();
       manager.persist(d);
       transaction.begin();
       transaction.commit();
   }
}
