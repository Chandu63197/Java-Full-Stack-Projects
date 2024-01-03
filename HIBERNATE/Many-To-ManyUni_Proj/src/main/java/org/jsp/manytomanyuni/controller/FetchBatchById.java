package org.jsp.manytomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class FetchBatchById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to fetch Batch details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Batch b = manager.find(Batch.class, id);
		if (b != null) {
			System.out.println("Batch Id:" + b.getId());
			System.out.println("Batch Subject:" + b.getSubject());
			System.out.println("Batch Code:" + b.getCode());
			System.out.println("Batch Trainer:"+b.getTrainer());
		} 
		else {
			System.out.println("Entered an Invalid Batch Id");
		}
		sc.close();
	}
}
