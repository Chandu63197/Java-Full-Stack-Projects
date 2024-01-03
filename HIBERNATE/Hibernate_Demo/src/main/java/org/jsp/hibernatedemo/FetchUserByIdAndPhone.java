package org.jsp.hibernatedemo;
import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchUserByIdAndPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the userId and PhoneNumber to display details");
		int id=sc.nextInt();
		long phone=sc.nextLong();
		String qry="select u from User u where id=?1 and u.phone=?2";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, phone);
		try {
			User u=q.getSingleResult();
			System.out.println("Id:"+u.getId());
			System.out.println("Name:"+u.getName());
			System.out.println("Phone Number:"+u.getPhone());
			System.out.println("Email:"+u.getEmail());
		} catch (NoResultException e) {
			System.out.println("You have entered an Invalid Id and PhoneNumber");
		}
	  } 
}
