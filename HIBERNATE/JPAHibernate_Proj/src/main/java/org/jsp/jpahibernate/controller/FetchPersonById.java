package org.jsp.jpahibernate.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.jpahibernate.dto.Person;
public class FetchPersonById {
  public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter an id");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Person p=manager.find(Person.class,id);
	if(p!=null) {
		System.out.println("Id:"+p.getId());
		System.out.println("Name:"+p.getName());
		System.out.println("Age:"+p.getAge());
		System.out.println("Phone:"+p.getPhone());
		System.out.println("Email id:"+p.getEmail());
	}
	else {
		System.out.println("You have entered an Invalid Id");
	}
	s.close();
  }
}
