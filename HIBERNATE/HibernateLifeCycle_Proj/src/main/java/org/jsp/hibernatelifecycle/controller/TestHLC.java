package org.jsp.hibernatelifecycle.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.hibernatelifecycle.dto.User;
public class TestHLC {
  public static void main(String[] args) {
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 EntityTransaction transaction=manager.getTransaction();
	 User u=new User();//Transient State
	 u.setName("ABC");
	 u.setPhone(998877);
	 u.setEmail("abc@gmail.com");
	 manager.persist(u);//Persistent State
	 transaction.begin();
	 transaction.commit();
	 u.setName("Virat");
	 u.setPhone(9988);
	 transaction.begin();
	 transaction.commit();
	 manager.detach(u);//Detached State
	 u.setName("Kohli");
	 u.setPhone(9630);
	 transaction.begin();
	 transaction.commit();
  }
}
