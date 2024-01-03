package org.jsp.manytomanyuni.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.manytomanyuni.dto.Student;
public class FindStudentsByBatchCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the batch Code to fetch Student details");
		String code = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select b.students from Batch b where b.code=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, code);
		List<Student> students=q.getResultList();
		if(students.size()>0) {
			for(Student s:students) {
			    System.out.println("Student Id:" + s.getId());
				System.out.println("Student Name:" + s.getName());
				System.out.println("Student Phone:" + s.getPhone());
				System.out.println("Student Perc:" + s.getPerc());
				System.out.println("----****----");
			}
		} 
		else{
			System.out.println("Entered an Invalid Batch Code");
		}
		sc.close();
	}
}
