package org.jsp.onetoonebiproj.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.AadharCard;
public class AadharCardByPincode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Pincode to fetch AadharCard details");
		int pincode= sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select a from AadharCard a where a.pincode=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, pincode);
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
			System.out.println("Entered an Invalid Pincode");
		}
		sc.close();
	}
}
