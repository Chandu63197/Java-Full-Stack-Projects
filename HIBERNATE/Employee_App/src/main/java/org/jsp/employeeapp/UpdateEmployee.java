package org.jsp.employeeapp;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class UpdateEmployee {
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the user id to update");
		 int id=sc.nextInt();
		 System.out.println("Enter the name,phone,password,salary and designation to update");
		 Employee e=new Employee();
		 e.setId(id);
		 e.setName(sc.next());
		 e.setPhone(sc.nextLong());
		 e.setPassword(sc.next());
		 e.setSalary(sc.nextDouble());
		 e.setDesignation(sc.next());
		 Configuration cfg=new Configuration();
		 cfg.configure();
		 SessionFactory factory=cfg.buildSessionFactory();
		 Session s=factory.openSession();
		 s.update(e);
		 Transaction t=s.beginTransaction();
		 t.commit();
	}
}
