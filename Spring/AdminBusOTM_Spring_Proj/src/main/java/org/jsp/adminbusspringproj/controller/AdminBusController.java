package org.jsp.adminbusspringproj.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.jsp.adminbusspringproj.AdminBusConfig;
import org.jsp.adminbusspringproj.dao.AdminDao;
import org.jsp.adminbusspringproj.dao.BusDao;
import org.jsp.adminbusspringproj.dto.Admin;
import org.jsp.adminbusspringproj.dto.Bus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdminBusController {
	static AdminDao dao;
	static BusDao dao1;
	static ApplicationContext context;
	static Scanner sc=new Scanner(System.in);
	static {
		context=new AnnotationConfigApplicationContext(AdminBusConfig.class);
		dao=context.getBean(AdminDao.class);
		dao1=context.getBean(BusDao.class);
	}
	public static void main(String[] args) {
		boolean b = true;
		while (b) {
			System.out.println("1.Save Admin");
			System.out.println("2.Update Admin");
			System.out.println("3.Find Admin By Id");
			System.out.println("4.Add Bus");
			System.out.println("5.Update Bus");
			System.out.println("6.Find Bus By Admin Id");
			System.out.println("7.Find Bus by from_loc,to_loc and date_of_departure");
			System.out.println("8.Verify Admin by phone and password");
			System.out.println("9.Verify Admin by email and password");
			System.out.println("10.Delete Admin");
			System.out.println("Enter Your Choice");
			switch (sc.nextInt()) {
			   case 1: {
				  saveAdmin();
				  break;
			   }
			   case 2: {
				  updateAdmin();
				  break;
			   }
			   case 3: {
				  findById();
				  break;
			   }
			   case 4: {
				  addBus();
				  break;
			   }
			   case 5: {
				  updateBus();
				  break;
			   }
			   case 6: {
				  findBusByAdminId();
				  break;
			   }
			   case 7:{
				  verifyByBus();
				  break;
			   }
			   case 8: {
				  verifyByPhone();
				  break;
			   }
			   case 9:{
				  verifyByEmail();
				  break;
			   }
			   case 10:{
				  deleteAdmin();
				  break;
			   }
			   default: {
				  System.out.println("Thank You!!!Application Closed");
				  ((AnnotationConfigApplicationContext) context).close();
				  b = false;
			   }
			}
		}
	}
	public static void saveAdmin() {
		System.out.println("Enter Your name,phone,email,gst and password to register");
		Admin a = new Admin();
		a.setName(sc.next());
		a.setPhone(sc.nextLong());
		a.setEmail(sc.next());
		a.setGst(sc.next());
		a.setPassword(sc.next());
		a = dao.saveAdmin(a);
		System.out.println("Admin saved with Id:" + a.getId());
	}

	public static void updateAdmin() {
		System.out.println("Enter the Admin Id to update");
		int id = sc.nextInt();
		System.out.println("Enter Your name,phone,email,gst and password to register");
		Admin a = new Admin();
		a.setId(id);
		a.setName(sc.next());
		a.setPhone(sc.nextLong());
		a.setEmail(sc.next());
		a.setGst(sc.next());
		a.setPassword(sc.next());
		a = dao.updateAdmin(a);
		System.out.println("Admin  Updated");
	}

	public static void findById() {
		System.out.println("Enter the Admin Id to display details");
		int id = sc.nextInt();
		Admin a = dao.findById(id);
		if (a != null) {
			System.out.println("Admin with Id " + id + " found");
			System.out.println("Admin id:" + a.getId());
			System.out.println("Admin Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email:" + a.getEmail());
			System.out.println("Gst:"+a.getGst());
			System.out.println("--------------------------");
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}
	public static void addBus() {
		Bus b = new Bus();
		System.out.println("Enter the Admin id to add Bus");
		int aid= sc.nextInt();
    	System.out.println("Enter the name,from_loc,to_loc,date_of_departure and cost_per_seat");
		b.setName(sc.next());
		b.setFrom_loc(sc.next());
		b.setTo_loc(sc.next());
		b.setDate_of_departure(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		b.setCost_per_seat(sc.nextDouble());
		b=dao1.addBus(b, aid);
		if (b != null)
			System.out.println("Bus add with Id:" + b.getId());
		else
			System.err.println("Invalid Amdin Id");
	}

	public static void updateBus() {
		System.out.println("Enter the Bus id to update");
		int aid = sc.nextInt();
    	System.out.println("Enter the name,from_loc,to_loc,date_of_departure and cost_per_seat to update");
		Bus b = new Bus();
		b.setId(sc.nextInt());
		b.setName(sc.next());
		b.setFrom_loc(sc.next());
		b.setTo_loc(sc.next());
		b.setDate_of_departure(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		b.setCost_per_seat(sc.nextDouble());
		b=dao1.updateBus(b, aid);
		if (b != null)
			System.out.println("Bus updated with Id:" + b.getId());
		else
			System.err.println("Invalid Admin Id");
	}
	public static void findBusByAdminId() {
		System.out.println("Enter the Admin id to find Bus");
		int aid = sc.nextInt();
		List<Bus> bus = dao1.findBusByAdminId(aid);
		if (bus.size() > 0) {
			for (Bus b : bus) {
				System.out.println("Bus Id:" + b.getId());
				System.out.println("Bus name:" + b.getName());
				System.out.println("From_loc"+b.getFrom_loc());
				System.out.println("To_loc"+b.getTo_loc());
				System.out.println("Date_of_Departure:"+b.getDate_of_departure());
				System.out.println("cost_per_seat:"+b.getCost_per_seat());
				System.out.println("------------------------------");
			}
		} else {
			System.err.println("Invalid Admin id");
		}
	}
	public static void verifyByBus() {
		System.out.println("Enter Your from_loc ,to_loc and date_of_departure to verify");
		String from_loc = sc.next();
		String to_loc = sc.next();
		LocalDate date_of_departure=LocalDate.parse(sc.next());
		List<Bus> bus=dao1.verifyBus(from_loc, to_loc, date_of_departure);
		if (bus.size() > 0) {
			for (Bus b : bus) {
				System.out.println("Bus Id:" + b.getId());
				System.out.println("Bus name:" + b.getName());
				System.out.println("From_loc"+b.getFrom_loc());
				System.out.println("To_loc"+b.getTo_loc());
				System.out.println("Date_of_Departure:"+b.getDate_of_departure());
				System.out.println("cost_per_seat:"+b.getCost_per_seat());
				System.out.println("------------------------------");
			}
		}else{
			System.err.println("Invalid from_loc ,to_loc and date_of_departure");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter Your Phone Number and password to verify");
		long phone = sc.nextLong();
		String password = sc.next();
		Admin a = dao.verifyAdmin(phone, password);
		if (a != null) {
			System.out.println("Admin Verified Succesfully");
			System.out.println("Admin id:" + a.getId());
			System.out.println("Admin Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email:" + a.getEmail());
			System.out.println("Gst:"+a.getGst());
			System.out.println("--------------------------");
		} else {
			System.err.println("Invalid Phone Number or Password");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter Your Email and password to verify");
		String email = sc.next();
		String password = sc.next();
		Admin a = dao.verifyAdmin(email, password);
		if (a != null) {
			System.out.println("Admin Verified Succesfully");
			System.out.println("Admin id:" + a.getId());
			System.out.println("Admin Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email:" + a.getEmail());
			System.out.println("Gst:"+a.getGst());
			System.out.println("--------------------------");
		} else {
			System.err.println("Invalid Email or Password");
		}
	}
	public static void deleteAdmin() {
		System.out.println("Enter the Admin Id to delete");
		int id = sc.nextInt();
		boolean deleted = dao.deleteAdmin(id);
		if (deleted) {
			System.out.println("Admin Found and deleted");
		} else {
			System.out.println("You have entered an Invalid Id");
		}
	}
}
