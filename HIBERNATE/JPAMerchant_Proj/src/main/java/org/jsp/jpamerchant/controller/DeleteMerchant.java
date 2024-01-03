package org.jsp.jpamerchant.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.jpamerchant.dto.Merchant;
public class DeleteMerchant {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter an id");
		int id=s.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Merchant m=manager.find(Merchant.class,id);
		if(m!=null) {
			manager.remove(m);
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			transaction.commit();
		}
		else {
			System.out.println("You have entered an Invalid Id");
		}
		s.close();
    }
}
