package org.jsp.hibernatedemo;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchPhonesFromUserByNames {
	  public static void main(String[] args) {  
		    Scanner sc=new Scanner(System.in);
			System.out.println("Enter the UserName to display all PhoneNumber details");
			String name=sc.next();
			String qry="select u.phone from User u where u.name=:name";
			Session s=new Configuration().configure().buildSessionFactory().openSession();
			Query<Long> q=s.createQuery(qry);
			q.setParameter("name", name);
			List<Long> phones=q.getResultList();
			for(Long phone:phones) {
				System.out.println(phone);
			}
	  } 
}
