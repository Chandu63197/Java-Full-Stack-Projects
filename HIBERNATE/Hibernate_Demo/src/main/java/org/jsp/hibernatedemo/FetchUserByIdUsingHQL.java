package org.jsp.hibernatedemo;
import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchUserByIdUsingHQL {
    public static void main(String[] args) {  
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter the userId to display details");
		int id=sc.nextInt();
		String qry="select u from User u where u.id=:id";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter("id", id);
		try {
			User u=q.getSingleResult();
			System.out.println("Id:"+u.getId());
			System.out.println("Name:"+u.getName());
			System.out.println("Phone Number:"+u.getPhone());
			System.out.println("Email:"+u.getEmail());
		} catch (NoResultException e) {
			System.out.println("You have entered an Invalid Id and Password");
		}
    } 
}

