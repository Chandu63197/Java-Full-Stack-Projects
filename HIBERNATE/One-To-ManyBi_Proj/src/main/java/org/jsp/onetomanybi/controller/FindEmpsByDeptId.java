package org.jsp.onetomanybi.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;
public class FindEmpsByDeptId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Department id to fetch the Employee details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Department d = manager.find(Department.class, id);
		if (d != null) {
			    List<Employee> emps=d.getEmps();
			for(Employee e :emps) {
				System.out.println("Employee id:"+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("Employee Designation:"+e.getDesg());
				System.out.println("Employee Salary:"+e.getSalary());
				System.out.println("-----*****-----");
			}
		} 
	    else {
			System.out.println("Invalid Department Id");
		}
		sc.close();
	}
}
