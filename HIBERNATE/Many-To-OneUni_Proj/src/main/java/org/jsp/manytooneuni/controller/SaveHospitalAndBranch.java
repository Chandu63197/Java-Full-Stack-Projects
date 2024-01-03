package org.jsp.manytooneuni.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.manytooneuni.dto.Branch;
import org.jsp.manytooneuni.dto.Hospital;
public class SaveHospitalAndBranch {
   public static void main(String[] args) {
	 Hospital h=new Hospital();
	 h.setFounder("ABC");
	 h.setName("ABC Hospital");
	 h.setYoestb(1956);
	 
	 Branch b1=new Branch();
	 b1.setEmail("abc@gmail.com");
	 b1.setName("ABC Delhi");
	 b1.setPhone(888777);
	 b1.setHospital(h);
	 
	 Branch b2=new Branch();
	 b2.setEmail("abcd@gmail.com");
	 b2.setName("ABC mysore");
	 b2.setPhone(888999);
	 b2.setHospital(h);
	 
	 Branch b3=new Branch();
	 b3.setEmail("abcde@gmail.com");
	 b3.setName("ABC Bangalore");
	 b3.setPhone(88877);
	 b3.setHospital(h);
	 
	 EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	 EntityTransaction transaction=manager.getTransaction();
	 manager.persist(b1);
	 manager.persist(b2);
	 manager.persist(b3);
	 transaction.begin();
	 transaction.commit();
   }
}
