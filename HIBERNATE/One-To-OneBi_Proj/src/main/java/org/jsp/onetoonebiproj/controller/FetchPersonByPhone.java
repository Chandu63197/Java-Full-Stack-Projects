package org.jsp.onetoonebiproj.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.Person;
public class FetchPersonByPhone {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the Person Phone to fetch Person details");
	  long phone=sc.nextLong();
	  EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
      String qry1="select p from Person p where p.phone=?1";
      Query q=manager.createQuery(qry1);
      q.setParameter(1, phone);
      try {
    	  Person p=(Person) q.getSingleResult();
    	  System.out.println("Id:"+p.getId());
    	  System.out.println("Person Name:"+p.getName());
    	  System.out.println("Person Phone:"+p.getPhone());
      }
      catch(NoResultException e) {
    	  System.out.println("Entered an Invalid Phone");
      }
  }
}
