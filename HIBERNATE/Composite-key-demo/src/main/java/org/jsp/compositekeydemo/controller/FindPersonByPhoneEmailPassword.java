package org.jsp.compositekeydemo.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.compositekeydemo.dto.Person;
import org.jsp.compositekeydemo.dto.PersonId;
public class FindPersonByPhoneEmailPassword {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the mail id and phone and password to fetch the person");
		String email = s.next();
		long phone = s.nextLong();
		String password=s.next();
		PersonId id = new PersonId();
		id.setEmail(email);
		id.setPhone(phone);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry="select p from Person p where p.id.phone=?1 and p.id.email=?2 and p.password=?3";
		Query q=manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2,email);
		q.setParameter(3, password);
		try {
			Person p=(Person)q.getSingleResult();
			System.out.println("Name:" + p.getName());
			System.out.println("Email Id:" + p.getId().getEmail());
			System.out.println("Phone Number:" + p.getId().getPhone());
		} catch(NoResultException e) {
			System.out.println("Invalid Phone Number or email or Password");
		}
	}
}
