package org.jsp.manytomanyuni.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Student;
public class FetchStudentById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to fetch Student details");
		int sid = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Student s = manager.find(Student.class, sid);
		if (s != null) {
			System.out.println("Student Id:" + s.getId());
			System.out.println("Student Name:" + s.getName());
			System.out.println("Student Phone:" + s.getPhone());
			System.out.println("Student Perc:"+s.getPerc());
		} 
		else {
			System.out.println("Entered an Invalid Student Id");
		}
		sc.close();
	}
}
