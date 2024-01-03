package org.jsp.manytomanyuni.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class SaveBatchAndStudent {
  public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
    Batch b1=new Batch();
    b1.setSubject("Hibernate");
    b1.setTrainer("Sathish");
    b1.setCode("JBT-JFRHID-M3");
    
    Batch b2=new Batch();
    b2.setSubject("React");
    b2.setTrainer("Prajwal");
    b2.setCode("JBT-JFRHCD-A2");
    
    Batch b3=new Batch();
    b3.setSubject("J2EE");
    b3.setTrainer("Gururaja");
    b3.setCode("JBT-JFRHED-A4");
    
    Student s1=new Student();
    s1.setName("Virat");
    s1.setPerc(84);
    s1.setPhone(88999);
    
    Student s2=new Student();
    s2.setName("Rohith");
    s2.setPerc(90);
    s2.setPhone(889969);
    
    Student s3=new Student();
    s3.setName("MSD");
    s3.setPerc(96);
    s3.setPhone(8899955);
    
    b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
    b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s3)));
    b3.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
    manager.persist(b1);
    manager.persist(b2);
    manager.persist(b3);
    transaction.begin();
    transaction.commit();
  }
}
