package org.jsp.jpahibernate.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.jpahibernate.dto.Person;
public class RemovePerson {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter an id");
		int id=s.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p=manager.find(Person.class,id);
		if(p!=null) {
			manager.remove(p);
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			transaction.commit();
		}
		else {
			System.out.println("You have entered an Invalid Id");
		}
		s.close();
	  }
}
