package org.jsp.onetoonebiproj.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.AadharCard;

public class FindAadharCardByPersonPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person Phone to fetch the Aadharcard details");
		long phone = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select a from AadharCard a where a.person.phone=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, phone);
		try {
			AadharCard card = (AadharCard) q.getSingleResult();
			System.out.println("Id:" + card.getId());
			System.out.println("Aadhar Number:" + card.getNumber());
			System.out.println("Date of Birth:" + card.getDob());
			System.out.println("Pincode:" + card.getPincode());
		} catch (NoResultException e) {
			System.out.println("Invalid Person Phone");
		}
		sc.close();
	}
}
