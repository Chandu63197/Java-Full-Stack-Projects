package org.jsp.onetoonebiproj.controller;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.onetoonebiproj.dto.AadharCard;
import org.jsp.onetoonebiproj.dto.Person;
public class SavePersonAndAadharCard {
  public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction =manager.getTransaction();
	
	Person p=new Person();
	p.setName("ABC");
	p.setPhone(9876543211L);
	
	AadharCard card=new AadharCard();
	card.setNumber(1213456123428L);
	card.setPincode(517421);
	card.setDob(LocalDate.parse("1947-08-15"));
	
	p.setCard(card);//Assigning AadharCard for Person
	card.setPerson(p);//Assigning Person for AadharCard
	manager.persist(p);
    transaction.begin();
	transaction.commit();
  }
}
