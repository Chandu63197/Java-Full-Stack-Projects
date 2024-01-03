package org.jsp.jpahibernate.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpahibernate.dto.Person;
public class SavePerson {
  public static void main(String[] args) {
	Person p=new Person();
	p.setName("ABC");
	p.setAge(25);
	p.setEmail("abcd@gmail.com");
	p.setPhone(8899775);
	p.setPassword("abc143");
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
    EntityManager manager=factory.createEntityManager();
    manager.persist(p);
    EntityTransaction transaction=manager.getTransaction();
    transaction.begin();
    transaction.commit();
    System.out.println("Person saved with Id:"+p.getId());
  }
}
