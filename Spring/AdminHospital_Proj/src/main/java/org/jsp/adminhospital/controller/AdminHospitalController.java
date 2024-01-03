package org.jsp.adminhospital.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.adminhospital.AdminHospitalConfig;
import org.jsp.adminhospital.dao.AdminDao;
import org.jsp.adminhospital.dao.HospitalDao;
import org.jsp.adminhospital.dto.Admin;
import org.jsp.adminhospital.dto.Hospital;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdminHospitalController {

	static AdminDao dao;
	static HospitalDao dao1;
	static ApplicationContext context;
	static Scanner sc = new Scanner(System.in);
	static {
		context = new AnnotationConfigApplicationContext(AdminHospitalConfig.class);
		dao = context.getBean(AdminDao.class);
		dao1 = context.getBean(HospitalDao.class);
	}

	public static void main(String[] args) {
		boolean b = true;
		while (b) {
			System.out.println("1.Save Admin");
			System.out.println("2.Update Admin");
			System.out.println("3.Verify Admin by phone and password");
			System.out.println("4.Verify Admin by email and password");
			System.out.println("5.Add Hospital");
			System.out.println("6.Update Hospital");
			System.out.println("7.Find hospital By Admin Id");
			System.out.println("8.Find Hospital By Name");
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
				verifyByPhone();
				break;
			}
			case 4: {
				verifyByEmail();
				break;
			}
			case 5: {
				addHospital();
				break;
			}
			case 6: {
				updateHospital();
				break;
			}
			case 7: {
				findByAdminId();
				break;
			}
			case 8: {
				findByName();
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
		System.out.println("Enter the name,phone,email and password");
		Admin a = new Admin();
		a.setName(sc.next());
		a.setPhone(sc.nextLong());
		a.setEmail(sc.next());
		a.setPassword(sc.next());
		a = dao.saveAdmin(a);
		System.out.println("Admin saved with the id:" + a.getId());
	}

	public static void updateAdmin() {
		Admin a = new Admin();
		System.out.println("Enter the Admin Id to update");
		int id = sc.nextInt();
		System.out.println("Enter the name,phone,email and password to update");
		a.setId(id);
		a.setName(sc.next());
		a.setPhone(sc.nextLong());
		a.setEmail(sc.next());
		a.setPassword(sc.next());
		a = dao.updateAdmin(a);
		System.out.println("Admin updated with Id:" + a.getId());
	}

	public static void verifyByPhone() {
		Admin a = new Admin();
		System.out.println("Enter the Phone and password to verify");
		long phone = sc.nextLong();
		String password = sc.next();
		a = dao.verify(phone, password);
		if (a != null) {
			System.out.println("Admin Id:" + a.getId());
			System.out.println("Admin Name:" + a.getName());
			System.out.println("Admin Phone:" + a.getPhone());
			System.out.println("Admin Email:" + a.getEmail());
			System.out.println("----------");
		} else {
			System.out.println("Invalid Phone and Paqssword");
		}
	}

	public static void verifyByEmail() {
		Admin a = new Admin();
		System.out.println("Enter Your Email and password to verify");
		String email = sc.next();
		String password = sc.next();
		a = dao.verify(email, password);
		if (a != null) {
			System.out.println("Admin Id:" + a.getId());
			System.out.println("Admin Name:" + a.getName());
			System.out.println("Admin Phone:" + a.getPhone());
			System.out.println("Admin Email:" + a.getEmail());
		} else {
			System.out.println("Invalid Phone and Paqssword");
		}
	}

	public static void addHospital() {
		Hospital h = new Hospital();
		System.out.println("Enter the Admin Id to add Hospital");
		int aid = sc.nextInt();
		System.out.println("enter the name,gst,founder,year of established");
		h.setName(sc.next());
		h.setGst(sc.next());
		h.setFounder(sc.next());
		h.setYear_of_estd(sc.next());
		h = dao1.addHospital(h, aid);
		if (h != null) {
			System.out.println("Hospital Add with Id:" + h.getId());
		} else {
			System.out.println("Invalid Admin Id");
		}
	}

	public static void updateHospital() {
		Hospital h = new Hospital();
		System.out.println("Enter the Admin Id to update Hospital");
		int aid = sc.nextInt();
		System.out.println("enter the name,gst,founder,year of established");
		h.setId(sc.nextInt());
		h.setName(sc.next());
		h.setGst(sc.next());
		h.setFounder(sc.next());
		h.setYear_of_estd(sc.next());
		h = dao1.updateHospital(h, aid);
		if (h != null) {
			System.out.println("Hospital updated with Id:" + h.getId());
		} else {
			System.out.println("Invalid Admin Id");
		}
	}

	public static void findByAdminId() {
		System.out.println("Enter the Admin Id to find product");
		int id = sc.nextInt();
		List<Hospital> hospital = dao1.findByAdminId(id);
		if (hospital.size() > 0) {
			for (Hospital h : hospital) {
				System.out.println("Hospital Id:" + h.getId());
				System.out.println("Name:" + h.getName());
				System.out.println("Gst:" + h.getGst());
				System.out.println("Founder:" + h.getFounder());
				System.out.println("Established:" + h.getYear_of_estd());
			}
		} else {
			System.out.println("Invalid Admin Id");
		}
	}

	public static void findByName() {
		System.out.println("Enter the hospital name to find product");
		String name = sc.next();
		List<Hospital> hospital = dao1.findByName(name);
		if (hospital.size() > 0) {
			for (Hospital h : hospital) {
				System.out.println("Hospital Id:" + h.getId());
				System.out.println("Name:" + h.getName());
				System.out.println("Gst:" + h.getGst());
				System.out.println("Founder:" + h.getFounder());
				System.out.println("Established:" + h.getYear_of_estd());
			}
		} else {
			System.out.println("Invalid Hospital  Name");
		}

	}

}