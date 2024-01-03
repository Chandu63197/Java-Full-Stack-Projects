package org.jsp.hibernatelifecycle.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hibernatelifecycle.dto.User;

public class DeleteUser {
    public static void main(String[] args) {
      EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
   	  EntityTransaction transaction=manager.getTransaction();
   	  User u=new User();//Transient State
   	  if(u!=null) {
   		 manager.remove(u);//remove state
   		 transaction.begin();
   		 transaction.commit();
   	  }
    }
}
