package org.jsp.hibernatedemo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchAllUsers {
  public static void main(String[] args) {
	String qry="select u from User u";
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	Query<User>q=s.createQuery(qry);
	List<User>users=q.getResultList();
	for(User u:users) {
		System.out.println("id:"+u.getId());
		System.out.println("Name:"+u.getName());
		System.out.println("Phone Number:"+u.getPhone());
		System.out.println("Email id:"+u.getEmail());
		System.out.println("-----***%%***-----");
	}
  }
}
