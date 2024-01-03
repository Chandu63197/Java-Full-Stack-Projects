package org.jsp.onetoonebiproj.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.onetoonebiproj.dto.AadharCard;
public class AadharCardById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to fetch AadharCard details");
		int aid = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		AadharCard card= manager.find(AadharCard.class, aid);
		if (card != null) {
			System.out.println("AadharCard Id:" + card.getId());
			System.out.println("AadharCard Number:"+card.getNumber());
			System.out.println("Date of Birth:"+card.getDob());
			System.out.println("Pincode:"+card.getPincode());
		} 
		else {
			System.out.println("Entered an Invalid AadharCard Id");
		}
		sc.close();
	}
}
