package org.jsp.onetomanybi.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.onetomanybi.dto.Department;
public class FindDepartmentById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to fetch Department details");
		int pid = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Department d = manager.find(Department.class, pid);
		if (d != null) {
			System.out.println("Department Id:" + d.getId());
			System.out.println("Department Name:" + d.getName());
			System.out.println("Department Location:" + d.getLocation());
			System.out.println("-----*****-----");
		} else {
			System.out.println("Entered an Invalid Department Id");
		}
		sc.close();
	}
}
