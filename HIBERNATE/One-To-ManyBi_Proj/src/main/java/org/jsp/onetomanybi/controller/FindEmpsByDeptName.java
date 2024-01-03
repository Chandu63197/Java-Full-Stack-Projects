package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FindEmpsByDeptName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the dept Name to find the employees");
		String name=sc.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		String qry1="select d.emps from Department d where d.name=?1";
		Query q=manager.createQuery(qry1);
		q.setParameter(1, name);
		List<Employee> emps=q.getResultList();
		if(emps.size()>0) {
			for(Employee e:emps) {
				System.out.println("Employee id:"+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("Employee Designation:"+e.getDesg());
				System.out.println("Employee Salary:"+e.getSalary());
				System.out.println("-----*****-----");
			}
		}
		else {
			System.out.println("Invalid department Name");
		}
	  }
}
