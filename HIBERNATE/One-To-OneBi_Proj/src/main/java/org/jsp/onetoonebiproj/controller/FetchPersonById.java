package org.jsp.onetoonebiproj.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.onetoonebiproj.dto.Person;
public class FetchPersonById {
  public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the id to fetch Person details");
	 int pid=sc.nextInt();
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 Person p=manager.find(Person.class, pid);
	 if(p!=null) {
		 System.out.println("Person Id:"+p.getId());
		 System.out.println("Person Name:"+p.getName());
		 System.out.println("Person Phone:"+p.getPhone());
	 }
	 else {
		 System.out.println("Entered an Invalid Person Id");
	 }
	 sc.close();
  }
} 
