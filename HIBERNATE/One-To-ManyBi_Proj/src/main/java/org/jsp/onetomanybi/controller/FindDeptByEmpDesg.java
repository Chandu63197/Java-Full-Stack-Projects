package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FindDeptByEmpDesg {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee desg to find the Department");
		String desg = sc.next();
		String qry1 = "select e.dept from Employee e where e.desg=?1";
		Query q = manager.createQuery(qry1);
		q.setParameter(1, desg);
		List<Department> dept = q.getResultList();
		if (dept.size() > 0) {
			for (Department d : dept) {
				System.out.println("Department id:" + d.getId());
				System.out.println("Department Name:" + d.getName());
				System.out.println("Department LOcation:" + d.getLocation());
				System.out.println("-----*****-----");
			}
		} else {
			System.out.println("Invalid department desg");
		}
	}
}
