package org.jsp.timestamp.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.timestamp.dto.FoodOrder;
public class UpdateOrder {
	 public static void main(String[] args) {
		 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		 EntityTransaction transaction=manager.getTransaction();
		 FoodOrder order=manager.find(FoodOrder.class, 2);
		 order.setFood_item("Mushroom Biryani");
		 order.setCost(200);
		 manager.merge(order);
		 transaction.begin();
		 transaction.commit();
	   }
}
