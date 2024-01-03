package org.jsp.onetomanybi.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.dto.Employee;
public class FindEmployeeById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to fetch Employee details");
		int pid = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Employee e = manager.find(Employee.class, pid);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Employee Designation:" + e.getDesg());
			System.out.println("Employee Salary:"+e.getSalary());
			System.out.println("-----*****-----");
		} else {
			System.out.println("Entered an Invalid Employee Id");
		}
		sc.close();
	}
}
