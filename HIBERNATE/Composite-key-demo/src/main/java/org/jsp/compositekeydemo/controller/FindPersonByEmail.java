package org.jsp.compositekeydemo.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.compositekeydemo.dto.Person;
public class FindPersonByEmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person Email to fetch Person details");
		String email = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select p from Person p where p.id.email=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, email);
		List<Person> ps = q.getResultList();
		if (ps.size() > 0) {
			for (Person p : ps) {
				System.out.println("Person Name:" + p.getName());
				System.out.println("Email id:" + p.getId().getEmail());
				System.out.println("Person Phone:" + p.getId().getPhone());
			}
		} else {
			System.out.println("Entered an Invalid Email");
		}
	}
}
