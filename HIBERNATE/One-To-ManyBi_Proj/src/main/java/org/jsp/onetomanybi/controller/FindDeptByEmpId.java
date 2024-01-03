package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;

public class FindDeptByEmpId {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee id to find the Department");
		int id=sc.nextInt();
		String qry1="select e.dept from Employee e where e.id=?1";
		Query q=manager.createQuery(qry1);
		q.setParameter(1, id);
		try{
			    Department d=(Department) q.getSingleResult();
				System.out.println("Department id:"+d.getId());
				System.out.println("Department Name:"+d.getName());
				System.out.println("Department LOcation:"+d.getLocation());
				System.out.println("-----*****-----");
		}
		catch(NoResultException e) {
			System.out.println("Invalid department id");
		}
	  }
}
