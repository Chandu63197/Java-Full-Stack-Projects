package org.jsp.compositekeydemo.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.compositekeydemo.dto.Person;
import org.jsp.compositekeydemo.dto.PersonId;
public class SavePerson {
    public static void main(String[] args) {
	   Scanner s=new Scanner(System.in);
	   System.out.println("Enter the name,phone,email and password to save the person");
	   EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	   EntityTransaction transaction =manager.getTransaction();
	   String name=s.next();
	   long phone=s.nextLong();
	   String email=s.next();
	   String password=s.next();
	   Person p=new Person();
	   p.setName(name);
	   p.setPassword(password);
	   PersonId id=new PersonId();
	   id.setEmail(email);
	   id.setPhone(phone);
	   p.setId(id);
	   manager.persist(p);
	   transaction.begin();
	   transaction.commit();
    }
}
