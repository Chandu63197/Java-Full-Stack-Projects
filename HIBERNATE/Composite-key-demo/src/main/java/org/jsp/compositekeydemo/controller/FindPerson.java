package org.jsp.compositekeydemo.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.compositekeydemo.dto.Person;
import org.jsp.compositekeydemo.dto.PersonId;
public class FindPerson {
   public static void main(String[] args) {
	 Scanner s=new Scanner(System.in);
	 System.out.println("Enter the mail id and phone to fetch the person");
	 String email=s.next();
	 long phone=s.nextLong();
	 PersonId id=new PersonId();
	 id.setEmail(email);
	 id.setPhone(phone);
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 Person p=manager.find(Person.class, id);
	 if(p!=null) {
		 System.out.println("Name:"+p.getName());
		 System.out.println("Email Id:"+p.getId().getEmail());
		 System.out.println("Phone Number:"+p.getId().getPhone());
	 }
	 else {
		 System.out.println("Invalid credentials");
	 }
   }
}
