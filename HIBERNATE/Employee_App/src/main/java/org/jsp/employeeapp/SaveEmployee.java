package org.jsp.employeeapp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class SaveEmployee {
	public static void main(String[] args) {
		Employee e=new Employee();
		e.setName("ChanduNaidu");
		e.setPhone(9876543210L);
		e.setPassword("Cj@2345");
		e.setSalary(50000);
		e.setDesignation("Developer");
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		int id=(Integer)s.save(e);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("User registered with id:"+id);
	}
}
