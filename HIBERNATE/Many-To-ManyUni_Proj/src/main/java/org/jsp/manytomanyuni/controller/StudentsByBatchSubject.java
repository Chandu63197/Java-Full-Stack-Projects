package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Student;

public class StudentsByBatchSubject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the batch Subject to fetch Student details");
		String subject = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select b.students from Batch b where b.subject=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, subject);
		List<Student> students = q.getResultList();
		if (students.size() > 0) {
			for (Student s : students) {
				System.out.println("Student Id:" + s.getId());
				System.out.println("Student Name:" + s.getName());
				System.out.println("Student Phone:" + s.getPhone());
				System.out.println("Student Perc:" + s.getPerc());
			}
		} else {
			System.out.println("Entered an Invalid Batch Subject");
		}
		sc.close();
	}
}
