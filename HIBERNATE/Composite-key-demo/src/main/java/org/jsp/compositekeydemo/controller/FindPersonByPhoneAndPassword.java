package org.jsp.compositekeydemo.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.compositekeydemo.dto.Person;
public class FindPersonByPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person phone and password to fetch Person details");
		long phone = sc.nextLong();
		String password = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select p from Person p where p.id.phone=?1 and p.password=?2";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<Person> per = q.getResultList();
		if (per.size() > 0) {
			for (Person p : per) {
				System.out.println("Person Name:" + p.getName());
				System.out.println("Email id:" + p.getId().getEmail());
				System.out.println("Person Phone:" + p.getId().getPhone());
			}
		} else {
			System.out.println("Entered an Invalid phone and password");
		}
	}
}
