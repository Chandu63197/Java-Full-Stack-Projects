package org.jsp.onetoonebiproj.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetoonebiproj.dto.Person;

public class FetchPerson {
  public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
    System.out.println(manager.find(Person.class, 1));
  }
}
