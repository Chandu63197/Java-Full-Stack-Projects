package org.jsp.onetoonebiproj.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.AadharCard;
public class AadharCardByDateofBirth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the AadharDateofBirth to fetch AadharCard details");
		LocalDate dob=LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select a from AadharCard a where a.dob=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, dob);
		List<AadharCard> a=q.getResultList();
		if(a.size()>0){
			for(AadharCard card:a) {
				System.out.println("AadharCard Id:" + card.getId());
				System.out.println("AadharCard Number:" + card.getNumber());
				System.out.println("Date of Birth:" + card.getDob());
				System.out.println("Pincode:" + card.getPincode());
				System.out.println("-----*****-----");
			}
		}
		else{
			System.out.println("Entered an Invalid AadharCard DateofBirth");
		}
		sc.close();
	}
}
