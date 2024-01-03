package org.jsp.hibernatedemo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class UpdateUser {
   public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the user id to update");
	 int id=sc.nextInt();
	 System.out.println("Enter the name,phone,email and passwprd to update");
	 User u=new User();
	 u.setId(id);
	 u.setName(sc.next());
	 u.setPhone(sc.nextLong());
	 u.setEmail(sc.next());
	 u.setPassword(sc.next());
	 Configuration cfg=new Configuration();
	 cfg.configure();
	 SessionFactory factory=cfg.buildSessionFactory();
	 Session s=factory.openSession();
	 s.update(u);
	 Transaction t=s.beginTransaction();
	 t.commit();
   }
} 
