package org.jsp.jpamerchant.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.jpamerchant.dto.Merchant;
public class SaveMerchant {
	public static void main(String[] args) {
		Merchant m=new Merchant();
		m.setName("ABC");
		m.setEmail("abcdef@gmail.com");
		m.setPhone(9876543210L);
		m.setPassword("abc143");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	    EntityManager manager=factory.createEntityManager();
	    manager.persist(m);
	    EntityTransaction transaction=manager.getTransaction();
	    transaction.begin();
	    transaction.commit();
	    System.out.println("Person saved with Id:"+m.getId());
	}
}
