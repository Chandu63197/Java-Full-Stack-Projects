package org.jsp.employeeapp;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchEmployeeByDesignation {
  public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the designation to display details");
	 String designation=sc.next();
	 String qry="select e from Employee e where e.designation=:designation";
	 // String qry="select e from Employee e where e.designation=?1";
	 Session s=new Configuration().configure().buildSessionFactory().openSession();
	 Query<Employee> q=s.createQuery(qry);
	 q.setParameter("designation", designation);
	 //q.setParameter(1, designation);
	 List<Employee> employees=q.getResultList();
	 if(employees.size()>0) {
		 for(Employee e:employees) {
			 System.out.println("Id:"+e.getId());
			 System.out.println("Name:"+e.getName());
		     System.out.println("Phone Number:"+e.getPhone());
	         System.out.println("Salary:"+e.getSalary());
	         System.out.println("Designation:"+e.getDesignation());
	         System.out.println("-----*****-----");
		 }
	 }
	 else {
		 System.out.println("You have Entered an Invalid Designation");
	 }
  }
}
