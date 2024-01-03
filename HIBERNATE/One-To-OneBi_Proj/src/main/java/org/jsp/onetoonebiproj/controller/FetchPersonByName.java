package org.jsp.onetoonebiproj.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebiproj.dto.Person;
public class FetchPersonByName {
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the Name to fetch Person details");
		 String name=sc.next();
		 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		 String qry1="select p from Person p where p.name=?1";
		 Query q=manager.createQuery(qry1);
		 q.setParameter(1, name);
		 List<Person> ps=q.getResultList();
		 if(ps.size()>0) {
			 for(Person p:ps)
			 {
			    System.out.println("Person Id:"+p.getId());
			    System.out.println("Person Name:"+p.getName());
			    System.out.println("Person Phone:"+p.getPhone());
			    System.out.println("------********------");
			 }
		 }
		 else {
			 System.out.println("Entered an Invalid Person Id");
		 }
		 sc.close();
	  }
}
