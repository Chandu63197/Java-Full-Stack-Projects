package org.jsp.employeeapp;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DeleteEmployee {
  public static void main(String[] args) {
	 Session s=new Configuration().configure().buildSessionFactory().openSession();
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the Employee Id to Delete a record");
	 int id=sc.nextInt();
	 Employee e=s.get(Employee.class, id);
	 Transaction t=s.beginTransaction();
	 if(e!=null) {
		 s.delete(e);
		 t.commit();
	 }
	 else {
		 System.out.println("You have entered an Invalid Id");
	 }
  }
}
