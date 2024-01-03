package org.jsp.onetoonebiproj.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.AadharCard;
public class FindAadharCardByPersonName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person Name to fetch the Aadharcard details");
		String name=sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select a from AadharCard a where a.person.name=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, name);
		List<AadharCard> a=q.getResultList();
		if(a.size()>0) {
			for(AadharCard card:a) {
				System.out.println("Id:" + card.getId());
				System.out.println("Aadhar Number:" + card.getNumber());
				System.out.println("Date of Birth:" + card.getDob());
				System.out.println("Pincode:" + card.getPincode());
				System.out.println("-----*****-----");
			}
		} 
		else{
			System.out.println("Invalid Person Phone");
		}
		sc.close();
	}
}
