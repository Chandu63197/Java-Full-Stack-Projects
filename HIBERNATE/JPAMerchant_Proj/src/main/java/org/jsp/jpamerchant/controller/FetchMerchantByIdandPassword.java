package org.jsp.jpamerchant.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.jpamerchant.dto.Merchant;
public class FetchMerchantByIdandPassword {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Id and Password to fetch the Merchant");
		int id= s.nextInt();
		String password = s.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("verifyMerchantByIdandPassword");
		q.setParameter(1, id);
		q.setParameter(2, password);
		List<Merchant> ms=q.getResultList();
		if(ms.size()>0) {
			for(Merchant m:ms) {
			  System.out.println("Id:" + m.getId());
			  System.out.println("Name:" + m.getName());
			  System.out.println("Phone:" + m.getPhone());
			  System.out.println("Email id:" + m.getEmail());
			}
		}
		else{
			System.out.println("No Merchant found with the entered id and password");
		}
		s.close();
	}
}
