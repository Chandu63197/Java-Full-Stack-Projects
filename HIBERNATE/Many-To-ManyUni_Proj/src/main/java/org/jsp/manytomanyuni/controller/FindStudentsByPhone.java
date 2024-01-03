package org.jsp.manytomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Student;

public class FindStudentsByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Phone to fetch Student details");
		long phone = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select s from Student s where s.phone=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, phone);
		try {
			Student s = (Student) q.getSingleResult();
			System.out.println("Student Id:" + s.getId());
			System.out.println("Student Name:" + s.getName());
			System.out.println("Student Phone:" + s.getPhone());
			System.out.println("Student Perc:" + s.getPerc());
		} catch (NoResultException e) {
			System.out.println("Entered an Invalid Student Phone");
		}
		sc.close();
	}
}
