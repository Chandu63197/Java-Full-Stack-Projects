package org.jsp.employeeapp;
import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class VerifyEmployeeByIdAndPassword {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the EmployeeId and Password to display details");
		int id=sc.nextInt();
		String password=sc.next();
		String qry="select e from Employee e where e.id=?1 and e.password=?2";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q=s.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			Employee e=q.getSingleResult();
			System.out.println("Id:"+e.getId());
			System.out.println("Name:"+e.getName());
			System.out.println("Phone Number:"+e.getPhone());
			System.out.println("Salary:"+e.getSalary());
			System.out.println("Designation:"+e.getDesignation());
		} 
		catch (NoResultException e) {
			System.out.println("You have entered an Invalid Id and PhoneNumber");
		}
	  } 
}
