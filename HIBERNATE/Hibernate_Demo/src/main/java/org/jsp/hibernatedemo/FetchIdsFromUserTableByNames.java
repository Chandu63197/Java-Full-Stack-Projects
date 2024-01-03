package org.jsp.hibernatedemo;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchIdsFromUserTableByNames {
	  public static void main(String[] args) {  
		    Scanner sc=new Scanner(System.in);
			System.out.println("Enter the UserName to display all Id details");
			String name=sc.next();
			String qry="select u.id from User u where u.name=:name";
			//String qry="select u.id from User u where u.name=?1";
			Session s=new Configuration().configure().buildSessionFactory().openSession();
			Query<Integer> q=s.createQuery(qry);
			q.setParameter("name", name);
			//q.setParameter(1, name);
			List<Integer> ids=q.getResultList();
			if(ids.size()>0) {
			   for(Integer id:ids) {
				  System.out.println(id);
			   }
			}
			else {
				System.out.println("You have entered an Invalid Username");
			}
			/*if(ids.size()>0) {
				for(Integer id:ids) {
					System.out.println(id);
				}
			}
			else {
				System.out.println("No username found");
			}*/
	  } 
}
