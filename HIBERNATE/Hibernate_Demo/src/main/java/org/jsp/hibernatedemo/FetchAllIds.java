package org.jsp.hibernatedemo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchAllIds {
	public static void main(String[] args) {
		 String qry="select u.id from User u";
		 Session s=new Configuration().configure().buildSessionFactory().openSession();
		 Query<Integer> q=s.createQuery(qry);
		 List<Integer> ids=q.getResultList();
		 for(int id:ids) {
			 System.out.println(id);
		 }
	   }
}
