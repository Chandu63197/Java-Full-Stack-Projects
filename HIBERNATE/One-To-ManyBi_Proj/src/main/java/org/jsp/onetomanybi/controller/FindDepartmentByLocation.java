package org.jsp.onetomanybi.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetomanybi.dto.Department;
public class FindDepartmentByLocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Location to fetch Department details");
		String location = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1 = "select d from Department d where d.location=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, location);
		List<Department> dept = q.getResultList();
		if (dept.size() > 0) {
			for (Department d : dept) {
				System.out.println("Deparment Id:" + d.getId());
				System.out.println("Department Name:" + d.getName());
				System.out.println("Department Location:" + d.getLocation());
				System.out.println("------********------");
			}
		} else {
			System.out.println("Entered an Invalid Department Location");
		}
		sc.close();
	}
}
