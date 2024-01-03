package org.jsp.timestamp.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.timestamp.dto.FoodOrder;
public class SaveOrder {
   public static void main(String[] args) {
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 EntityTransaction transaction=manager.getTransaction();
	 FoodOrder order=new FoodOrder();
	 order.setFood_item("Biryani");
	 order.setCost(350);
	 manager.persist(order);
	 transaction.begin();
	 transaction.commit();
   }
}
