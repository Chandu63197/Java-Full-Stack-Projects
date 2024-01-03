package org.jsp.jpamerchant.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.jpamerchant.dto.Merchant;
public class FetchMerchantById {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter an id");
		int id=s.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Merchant m=manager.find(Merchant.class,id);
		if(m!=null) {
			System.out.println("Id:"+m.getId());
			System.out.println("Name:"+m.getName());
			System.out.println("Phone:"+m.getPhone());
			System.out.println("Email id:"+m.getEmail());
		}
		else {
			System.out.println("You have entered an Invalid Id");
		}
		s.close();
	  }
}
