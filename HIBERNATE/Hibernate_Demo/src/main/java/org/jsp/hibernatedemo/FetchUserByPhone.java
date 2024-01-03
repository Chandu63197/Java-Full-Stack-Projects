package org.jsp.hibernatedemo;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchUserByPhone {
	public static void main(String[] args) {  
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter the PhoneNumbers to display details");
		long phone=sc.nextLong();
		String qry="select u from User u where u.phone=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, phone);
		List<User> users=q.getResultList();
		if(users.size()>0){
			for(User u:users) {
			   System.out.println("Id:"+u.getId());
			   System.out.println("Name:"+u.getName());
			   System.out.println("Phone Number:"+u.getPhone());
			   System.out.println("Email:"+u.getEmail());
			}
		}
		else{
			System.out.println("You have entered an Invalid Phone");
		}
    } 
}
