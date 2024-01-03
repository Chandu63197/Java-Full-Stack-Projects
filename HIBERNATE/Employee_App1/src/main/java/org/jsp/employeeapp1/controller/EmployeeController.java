package org.jsp.employeeapp1.controller;
import java.util.List;

import java.util.Scanner;

import org.jsp.employeeapp1.dao.EmployeeDao;
import org.jsp.employeeapp1.dto.Employee;
public class EmployeeController {
	static Scanner s = new Scanner(System.in);
	static EmployeeDao dao = new EmployeeDao();
	public static void main(String[] args) {
        System.out.println("1.Save Employee");
        System.out.println("2.Update Employee");
        System.out.println("3.Find Employee By Id");
        System.out.println("4.Verify Employee By Phone and Password");
        System.out.println("5.Verify Employee By Id and Password");
        System.out.println("6.Delete Employee");
        System.out.println("7.Find Employee By Designation");
        int choice=s.nextInt();
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
        	   employeeById();
        	   break;
           }
           case 4:{
        	   verifyByPhone();
        	   break;
           }
           case 5:{
        	   verifyById();
        	   break;
           }
           case 6:{
        	   delEmp();
        	   break;
           }
           case 7:{
        	   byDesg();
        	   break;
           }
           default:{
        	   System.out.println("Invalid Choice");
           }
        }
	}
	public static void save() {
		System.out.println("Enter the Employee name,desg,salary,phone and password");
		Employee e=new Employee();
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setPassword(s.next());
		e=dao.saveEmployee(e);
		System.out.println("Employee saved with Id:"+e.getId());
	}
	public static void update() {
		System.out.println("Enter your Id to update");
		int id=s.nextInt();
		System.out.println("Enter the Employee name,desg,salary,phone and password");
		Employee e=new Employee();
		e.setId(id);
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setPassword(s.next());
		e=dao.updateEmployee(e);
		System.out.println("Employee updated with Id:"+e.getId());
	}
	public static void employeeById() {
		 System.out.println("Enter your Id to display");
		 int id=s.nextInt();
		 Employee e=dao.FindById(id);
		 if(e!=null) {
			 System.out.println("User id:"+e.getId());
			 System.out.println("Name:"+e.getName());
			 System.out.println("Phone:"+e.getPhone());
			 System.out.println("Salary:"+e.getSalary());
			 System.out.println("Designation:"+e.getDesg());
		 }
		 else {
			 System.out.println("You have entered an Invalid Id");
		 }
	}
	public static void verifyByPhone() {
		System.out.println("Enter your Phone and Password to verify");
		long phone=s.nextLong();
		String password=s.next();
		Employee e=dao.VerifyEmployee(phone, password);
		if(e!=null) {
			System.out.println("Employee Id:"+e.getId());
			System.out.println("Employee Name:"+e.getName());
			System.out.println("Employee Phone:"+e.getPhone());
			System.out.println("Employee salary:"+e.getSalary());
			System.out.println("Employee Designation:"+e.getDesg());
		}
		else {
			System.out.println("You have entered an Invalid Phone and Password");
		}
	}
	public static void verifyById() {
		System.out.println("Enter your Id and Password to verify");
		int id=s.nextInt();
		String password=s.next();
		Employee e=dao.VerifyEmployee(id, password);
		if(e!=null) {
			System.out.println("Employee Id:"+e.getId());
			System.out.println("Employee Name:"+e.getName());
			System.out.println("Employee Phone:"+e.getPhone());
			System.out.println("Employee salary:"+e.getSalary());
			System.out.println("Employee Designation:"+e.getDesg());
		}
		else {
			System.out.println("You have entered an Invalid Phone and Password");
		}
	}
	public static void delEmp() {
		 System.out.println("Enter the Employee Id to Delete a record");
		 int id=s.nextInt();
		 boolean e=dao.DeleteEmployee(id);
		 if(e) {
			 System.out.println("Record has been deleted");
		 }
		 else {
			 System.out.println("You have entered an Invalid Id");
		 }
	}
	public static void byDesg() {
		 System.out.println("Enter your Deisgnation to display");
		 String desg=s.next();
		 List<Employee> emp=dao.FindByDesignation(desg);
		 if(emp.size()>0) {
			for(Employee e:emp) {
				System.out.println("User id:"+e.getId());
				System.out.println("Name:"+e.getName());
			    System.out.println("Phone:"+e.getPhone());
			    System.out.println("Salary:"+e.getSalary());
				System.out.println("Designation:"+e.getDesg());
			}
		 }
		 else {
			 System.out.println("You have entered an Invalid Designation");
		 }
	}
}

