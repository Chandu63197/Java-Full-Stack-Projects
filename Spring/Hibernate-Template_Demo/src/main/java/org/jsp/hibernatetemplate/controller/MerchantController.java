package org.jsp.hibernatetemplate.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hibernatetemplate.dao.MerchantDao;
import org.jsp.hibernatetemplate.dto.Merchant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MerchantController {
    static Scanner sc=new Scanner(System.in);
    private static MerchantDao dao;
    static ApplicationContext context;
    static {
        context=new ClassPathXmlApplicationContext("hib-template.xml");
    	dao=context.getBean(MerchantDao.class);
    }
    public static void main(String[] args) {
		boolean b=true;
		while(b) {
			System.out.println("1.Save Merchant");
			System.out.println("2.Update Merchant");
			System.out.println("3.Find Merchant By Id");
			System.out.println("4.Delete Merchant By Id");
			System.out.println("5.Find All Merchant");
			System.out.println("Enter the choice");
			int choice=sc.nextInt();
			switch(choice) {
			   case 1:{
				   save();
				   break;
			   }
			   case 2:{
				   update();
				   break;
			   }
			   case 3:{
				   findById();
				   break;
			   }
			   case 4:{
				   delete();
				   break;
			   }
			   case 5:{
				   findAll();
				   break;
			   }
			   default:{
				   b=false;
				   System.out.println("Thank you Application Closed!!!");
				   ((ClassPathXmlApplicationContext) context).close();
			   }
			}
		}
	}
    public static void save() {
    	System.out.println("Enter the name,phone,email,gst and password to save merchant");
    	Merchant m=new Merchant();
    	m.setName(sc.next());
    	m.setPhone(sc.nextLong());
    	m.setEmail(sc.next());
    	m.setGst(sc.next());
    	m.setPassword(sc.next());
    	m=dao.saveMerchant(m);
    	System.out.println("Merchant saved with Id:"+m.getId());
    }
    public static void update() {
    	System.out.println("Enter the merchant id to update");
    	int id=sc.nextInt();
    	System.out.println("Enter the name,phone,email,gst and password to save merchant");
    	Merchant m=new Merchant();
    	m.setId(id);
    	m.setName(sc.next());
    	m.setPhone(sc.nextLong());
    	m.setEmail(sc.next());
    	m.setGst(sc.next());
    	m.setPassword(sc.next());
    	m=dao.updateMerchant(m);
    	System.out.println("Merchant updated");
    }
    public static void findById() {
    	System.out.println("Enter the merchant Id to find merchant");
    	int id=sc.nextInt();
    	Merchant m=dao.findById(id);
    	if(m!=null) {
    		System.out.println("Merchant Id:"+m.getId());
    		System.out.println("Merchant Name:"+m.getName());
    		System.out.println("Merchant Phone:"+m.getPhone());
    		System.out.println("Merchant Email:"+m.getEmail());
    		System.out.println("Merchant Gst:"+m.getGst());
    		System.out.println("Merchant Password:"+m.getPassword());
    		System.out.println("======================");
    	}
    	else {
    		System.out.println("Invalid Merchant Id");
    	}
    }
    public static void findAll() {
        List<Merchant> merchants=dao.findAll();
        for(Merchant m:merchants) {
        	System.out.println("Merchant Id:"+m.getId());
    		System.out.println("Merchant Name:"+m.getName());
    		System.out.println("Merchant Phone:"+m.getPhone());
    		System.out.println("Merchant Email:"+m.getEmail());
    		System.out.println("Merchant Gst:"+m.getGst());
    		System.out.println("Merchant Password:"+m.getPassword());
    		System.out.println("======================");
        }
    }
    public static void delete() {
    	System.out.println("Enter the Merchant Id to find merchant");
    	int id=sc.nextInt();
    	if(dao.deleteMerchant(id)) {
    		System.out.println("Merchant deleted");
    	}
    	else {
    		System.out.println("Invalid Merchant Id");
    	}
    }
}
