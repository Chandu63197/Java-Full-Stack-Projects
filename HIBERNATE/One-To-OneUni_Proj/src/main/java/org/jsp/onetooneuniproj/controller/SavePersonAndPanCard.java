package org.jsp.onetooneuniproj.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetooneuniproj.dto.PanCard;
import org.jsp.onetooneuniproj.dto.Person;

public class SavePersonAndPanCard {
  public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	Person p=new Person();//transient state
	p.setName("ABC");
	p.setPhone(88997);
	
	PanCard card=new PanCard();//transient state
	card.setNumber("etupt6655rt");
	card.setPincode(517421);
	card.setDob(LocalDate.parse("1947-08-15"));
	
	p.setCard(card);//Assigning Card to Person
	manager.persist(p);//persistent state
	transaction.begin();
	transaction.commit();
  }
}
