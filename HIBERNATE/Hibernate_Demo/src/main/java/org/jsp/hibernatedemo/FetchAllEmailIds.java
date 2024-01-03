package org.jsp.hibernatedemo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchAllEmailIds {
	public static void main(String[] args) {
		 String qry="select u.email from User u";
		 Session s=new Configuration().configure().buildSessionFactory().openSession();
		 Query<String> q=s.createQuery(qry);
		 List<String> emails=q.getResultList();
		 for(String email:emails) {
			 System.out.println(email);
		 }
	   }
}
