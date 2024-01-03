package org.jsp.hibernatedemo;
import java.util.Scanner;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
public class FetchUser {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the user Id to print the details");
		int uid=sc.nextInt();
        Session s=new Configuration().configure().buildSessionFactory().openSession();
        User u=s.load(User.class, uid);
        try {
          System.out.println("Enter Id:"+u.getId());
          System.out.println("Enter Name:"+u.getName());
          System.out.println("Enter Mail:"+u.getEmail());
          System.out.println("Enter Password:"+u.getPassword());
          System.out.println("Enter Phone:"+u.getPhone());
        }
        catch(ObjectNotFoundException e) {
        	System.out.println("You have entered an Invalid Id");
        }
	}
}
