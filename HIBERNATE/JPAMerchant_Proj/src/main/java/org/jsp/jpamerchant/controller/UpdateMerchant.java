package org.jsp.jpamerchant.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.jpamerchant.dto.Merchant;
public class UpdateMerchant {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter an id to update");
		int id=s.nextInt();
		Merchant m=new Merchant();
		System.out.println("Enter a name,mail,passowrd,phone to update");
		m.setId(id);
		m.setName(s.next());
		m.setEmail(s.next());
		m.setPhone(s.nextLong());
		m.setPassword(s.next());
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		manager.merge(m);
		EntityTransaction t=manager.getTransaction();
		t.begin();
		t.commit();
		System.out.println("Record Updated");
		s.close();
	  }
}
