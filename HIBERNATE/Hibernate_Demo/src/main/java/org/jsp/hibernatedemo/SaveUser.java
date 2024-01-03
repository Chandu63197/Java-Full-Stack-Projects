package org.jsp.hibernatedemo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class SaveUser {
    public static void main(String[] args) {
		User u=new User();
		u.setEmail("chandu@gmail.com");
		u.setName("ChanduNaidu");
		u.setPassword("Cj@2345");
		u.setPhone(987667);
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		int id=(Integer)s.save(u);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("User registered with id:"+id);
	}
}
