package org.jsp.hibernatetemplate.controller;

import java.util.Scanner;

import org.jsp.hibernatetemplate.dao.UserDao;
import org.jsp.hibernatetemplate.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
	static Scanner sc = new Scanner(System.in);
	private static UserDao dao;
	static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("hibernate-template.xml");
		dao = context.getBean(UserDao.class);
	}

	public static void main(String[] args) {
		boolean b = true;
		while (b) {
			System.out.println("1.Save User");
			System.out.println("2.Update User");
			System.out.println("Enter the choice");
			switch (sc.nextInt()) {
			   case 1: {
			    	save();
			    	break;
			   }
			   case 2:{
				    update();
				    break;
			   }
			}
		}
	}

	public static void save() {
		System.out.println("Enter the name,age,phone,gender,eamil and password to save");
		User u = new User();
		u.setName(sc.next());
		u.setAge(sc.nextInt());
		u.setPhone(sc.nextLong());
		u.setGender(sc.next());
		u.setEmail(sc.next());
		u.setPassword(sc.next());
		u = dao.saveUser(u);
		System.out.println("User saved with Id:"+u.getId());
	}
	
	public static void update() {
		System.out.println("Enter the id to update");
		int id=sc.nextInt();
		System.out.println("Enter the name,age,phone,gender,eamil and password to save");
		User u = new User();
		u.setId(id);
		u.setName(sc.next());
		u.setAge(sc.nextInt());
		u.setGender(sc.next());
		u.setPhone(sc.nextLong());
		u.setEmail(sc.next());
		u.setPassword(sc.next());
		u = dao.updateUser(u);
		System.out.println("User saved with Id:"+u.getId());
	}

}
