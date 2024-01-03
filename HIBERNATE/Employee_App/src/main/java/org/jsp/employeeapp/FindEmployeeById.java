package org.jsp.employeeapp;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
public class FindEmployeeById {
	public static void main(String[] args) {
		 Session s=new Configuration().configure().buildSessionFactory().openSession();
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the EmployeeId to display details:");
		 int id=sc.nextInt();
		 Employee e=s.get(Employee.class, id);
		 if(e!=null) {
			 System.out.println("User id:"+e.getId());
			 System.out.println("Name:"+e.getName());
			 System.out.println("Phone:"+e.getPhone());
			 System.out.println("Salary:"+e.getSalary());
			 System.out.println("Designation:"+e.getDesignation());
		 }
		 else {
			 System.out.println("You have entered an Invalid Id");
		 }
	   }
}
