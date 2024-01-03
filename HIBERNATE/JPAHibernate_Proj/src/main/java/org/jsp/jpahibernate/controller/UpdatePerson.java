package org.jsp.jpahibernate.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.jpahibernate.dto.Person;
public class UpdatePerson {
  public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter an id to update");
	int id=s.nextInt();
	Person p=new Person();
	System.out.println("Enter a name,age,mail,passowrd,phone to update");
	p.setId(id);
	p.setName(s.next());
	p.setAge(s.nextInt());
	p.setEmail(s.next());
	p.setPhone(s.nextLong());
	p.setPassword(s.next());
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	manager.merge(p);
	EntityTransaction t=manager.getTransaction();
	t.begin();
	t.commit();
	System.out.println("Record Updated");
	s.close();
  }
}
