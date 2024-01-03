package org.jsp.employeeapp;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class VerifyEmployeePhoneAndPassword {
   public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the Employee Phone And Password to dispaly Details");
	 long phone=sc.nextLong();
	 String password=sc.next();
	 String qry="select e from Employee e where e.phone=?1 and e.password=?2";
	 Session s=new Configuration().configure().buildSessionFactory().openSession();
	 Query<Employee> q=s.createQuery(qry);
	 q.setParameter(1, phone);
	 q.setParameter(2, password);
	 List<Employee> employees=q.getResultList();
	 if(employees.size()>0) {
		 for(Employee e:employees) {
		   System.out.println("Id:"+e.getId());
		   System.out.println("Name:"+e.getName());
		   System.out.println("Phone:"+e.getPhone());
		   System.out.println("Salary:"+e.getSalary());
		   System.out.println("Designation:"+e.getDesignation());
		   System.out.println("-----*****-----");
		 }
	 } 
     else{
		 System.out.println("You have entered an Invalid Phone and Password");
	 }
   }
}
