package org.jsp.jpamerchant.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.jpamerchant.dto.Merchant;
public class FetchMerchantByPhoneandPassword {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("verifyMerchantByPhoneandPassword");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Phone number and password  to verify the Merchant");
		long phone=s.nextLong();
		String password=s.next();
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try{
			    Merchant m=(Merchant)q.getSingleResult();
				System.out.println("Id:" + m.getId());
				System.out.println("Name:" + m.getName());
				System.out.println("Phone:" + m.getPhone());
				System.out.println("Email id:" + m.getEmail());
		} catch(NoResultException e){
			System.out.println("No person found with the entered Phone number and password");
		}
	}
}
