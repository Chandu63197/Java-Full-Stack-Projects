package org.jsp.onetoonebiproj.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetoonebiproj.dto.AadharCard;
import org.jsp.onetoonebiproj.dto.Person;
public class FetchAadharCardByPersonId {
   public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the Person id to fetch the Aadharcard details");
	 int pid=sc.nextInt();
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 Person p=manager.find(Person.class,pid);
	 if(p!=null) {
		 AadharCard card=p.getCard();
		 if(card!=null) {
			 System.out.println("Id:"+card.getId());
			 System.out.println("Aadhar Number:"+card.getNumber());
			 System.out.println("Date of Birth:"+card.getDob());
			 System.out.println("Pincode:"+card.getPincode());
		 }
	 }
	 else {
		 System.out.println("Invalid Person Id");
	 }
	 sc.close();
   }
}
