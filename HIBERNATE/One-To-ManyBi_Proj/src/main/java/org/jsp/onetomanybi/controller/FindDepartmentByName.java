package org.jsp.onetomanybi.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;
public class FindDepartmentByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name to fetch Department details");
		String name = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select d from Department d where d.name=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, name);
		List<Department> dept = q.getResultList();
		if (dept.size() > 0) {
			for (Department d : dept) {
				System.out.println("Deparment Id:" + d.getId());
				System.out.println("Department Name:" + d.getName());
				System.out.println("Department Location:" + d.getLocation());
				System.out.println("------********------");
			}
		} else {
			System.out.println("Entered an Invalid Department Name");
		}
		sc.close();
	}
}
