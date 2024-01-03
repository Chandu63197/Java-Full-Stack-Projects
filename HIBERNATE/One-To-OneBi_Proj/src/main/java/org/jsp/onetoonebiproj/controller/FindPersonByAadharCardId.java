package org.jsp.onetoonebiproj.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.AadharCard;
import org.jsp.onetoonebiproj.dto.Person;
public class FindPersonByAadharCardId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Aadhar id to fetch the Person details");
		int pid = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select p from Person p where p.card.id=?1";
		String qry2 = "select a.person from AadharCard a where a.id=?1";
		Query q = manager.createQuery(qry2);
		q.setParameter(1, pid);
		try {
			Person person = (Person) q.getSingleResult();
			System.out.println("Id:" + person.getId());
			System.out.println("Person Name:"+person.getName());
			System.out.println("Person Phone:"+person.getPhone());
		} 
		catch (NoResultException e) {
			System.out.println("Invalid AadharCard id");
		}
		sc.close();
	}
}
