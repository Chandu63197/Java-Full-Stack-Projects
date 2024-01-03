package org.jsp.onetoonebiproj.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.AadharCard;
public class AadharCardByNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the AadharNumber to fetch AadharCard details");
		long number = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1="select a from AadharCard a where a.number=?1";
		Query q=manager.createQuery(qry1);
		q.setParameter(1, number);
		try{
			AadharCard card=(AadharCard) q.getSingleResult();
			System.out.println("AadharCard Id:" + card.getId());
			System.out.println("AadharCard Number:" + card.getNumber());
			System.out.println("Date of Birth:" + card.getDob());
			System.out.println("Pincode:" + card.getPincode());
		} 
		catch (NoResultException e) {
			System.out.println("Entered an Invalid AadharCard Number");
		}
		sc.close();
	}
}
