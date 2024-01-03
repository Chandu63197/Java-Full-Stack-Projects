package org.jsp.jpahibernate.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpahibernate.dto.Person;

public class FindPersonByIdAndName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id and name to fetch the person");
		int id=s.nextInt();
		String email = s.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("verifyPersonByIdandName");
		q.setParameter(1, id);
		q.setParameter(2, email);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Id:" + p.getId());
			System.out.println("Name:" + p.getName());
			System.out.println("Age:" + p.getAge());
			System.out.println("Phone:" + p.getPhone());
			System.out.println("Email id:" + p.getEmail());
		} catch (NoResultException e) {
			System.out.println("No person found with the entered email");
		}
		s.close();
	}
}

