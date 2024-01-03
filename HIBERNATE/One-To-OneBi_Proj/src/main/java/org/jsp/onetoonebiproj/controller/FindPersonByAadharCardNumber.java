package org.jsp.onetoonebiproj.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebiproj.dto.Person;
public class FindPersonByAadharCardNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Aadhar Number to fetch the Person details");
		long number = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select p from Person p where p.card.number=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, number);
		try {
			Person person=(Person)q.getSingleResult();
			System.out.println("Id:" + person.getId());
			System.out.println("Person Name:" + person.getName());
			System.out.println("Person Phone:" + person.getPhone());
		} catch (NoResultException e) {
			System.out.println("Invalid AadharCard Number");
		}
		sc.close();
	}
}
