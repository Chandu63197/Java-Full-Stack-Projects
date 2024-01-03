package org.jsp.assignment1.controller;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.jsp.assignment1.dao.DepartmentDao;
import org.jsp.assignment1.dao.EmployeeDao;
import org.jsp.assignment1.dto.Department;
import org.jsp.assignment1.dto.Employee;
public class EmpDeptController {
	static Scanner s = new Scanner(System.in);
	static EmployeeDao dao = new EmployeeDao();
	static DepartmentDao dao1 = new DepartmentDao();
	public static void main(String[] args) {
		System.out.println("1.Save the Department");
		System.out.println("2.Save the Employee");
		System.out.println("3.Update the Department");
		System.out.println("4.Update the Employee");
		System.out.println("5.Find Employee By Department Id");
		System.out.println("6.Find Employee By Department Name");
		System.out.println("7.Verify Employee By Phone and Password");
		System.out.println("8.Verify Employee By Email and password");
		System.out.println("9.Verify Employee By Id and Password");
		System.out.println("10.Find Department By Id");
		int choice = s.nextInt();
		switch (choice) {
		case 1: {
			saveDept();
			break;
		}
		case 2: {
			saveEmp();
			break;
		}
		case 3: {
			updateDept();
			break;
		}
		case 4: {
			updateEmp();
			break;
		}
		case 5: {
			verifyEmpByDeptId();
			break;
		}
		case 6: {
			verifyEmpByDeptName();
			break;
		}
		case 7: {
			verifyEmpByPhonePassword();
			break;
		}
		case 8: {
			verifyEmpByEmailPassword();
			break;
		}
		case 9: {
			verifyEmpByIdPassword();
			break;
		}
		case 10: {
			deptById();
			break;
		}
		default: {
			System.out.println("Invalid Choice");
		}
	    }
	}
	public static void saveDept() {
		System.out.println("Enter the Department name and location");
		Department d = new Department();
		d.setName(s.next());
	    d.setLocation(s.next());
		d = dao1.saveDepartment(d);
		System.out.println("Department saved with Id:" + d.getId());
	}
	public static void saveEmp() {
		System.out.println("Enter the Employee name,desg,salary,phone,email and password");
		Employee e = new Employee();
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setPassword(s.next());
		System.out.println("Enter Department id to join");
		int id=s.nextInt();
		Department d=dao1.findById(id);
		if(d!=null) {
			e.setDept(d);
			e=dao.saveEmployee(e);
			System.out.println("Employee saved with Id:" + e.getId());
		}
		else {
			System.out.println("Invalid Department id");
		}
	}
	public static void updateDept() {
		System.out.println("Enter your Id to update");
		int id = s.nextInt();
		System.out.println("Enter the Employee name,desg,salary,phone,email and password");
		Department d = new Department();
		d.setId(id);
		d.setName(s.next());
		d.setLocation(s.next());
		d = dao1.updateDepartment(d);
		System.out.println("Department updated with Id:" + d.getId());
	}
	public static void updateEmp() {
		System.out.println("Enter your Id to update");
		int id = s.nextInt();
		System.out.println("Enter the Employee name,desg,salary,phone,email and password to update");
		Employee e = new Employee();
		e.setId(id);
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setPassword(s.next());
		e = dao.updateEmployee(e);
		System.out.println("Employee updated with Id:" + e.getId());
	}
	public static void verifyEmpByDeptId() {
		System.out.println("Enter Department Id to display the employee details");
		int id=s.nextInt();
		List<Employee> emp=dao.FindEmpByDeptId(id);
		if(emp.size()>0) {
			for(Employee e:emp) {
				System.out.println("Employee Id:"+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("Employee Phone:"+e.getPhone());
				System.out.println("Email:"+e.getEmail());
				System.out.println("Employee salary:"+e.getSalary());
				System.out.println("Employee Designation:"+e.getDesg());
				System.out.println("-----*****-----");
			}
		}
		else {
			System.out.println("You have entered an Invalid Department Id");
		}
	}
	public static void verifyEmpByDeptName() {
		System.out.println("Enter Department Name to display the employee details");
		String name=s.next();
		List<Employee> emp=dao.FindEmpByDeptName(name);
		if(emp.size()>0) {
			for(Employee e:emp) {
				System.out.println("Employee Id:"+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("Employee Phone:"+e.getPhone());
				System.out.println("Email:"+e.getEmail());
				System.out.println("Employee salary:"+e.getSalary());
				System.out.println("Employee Designation:"+e.getDesg());
				System.out.println("-----*****-----");
			}
		}
		else {
			System.out.println("You have entered an Invalid Department Name");
		}
	}
	public static void verifyEmpByPhonePassword() {
		System.out.println("Enter your Phone and Password to verify");
		long phone=s.nextLong();
		String password=s.next();
		try {
		    Employee e=dao.VerifyEmployee(phone, password);
			System.out.println("Employee Id:"+e.getId());
			System.out.println("Employee Name:"+e.getName());
			System.out.println("Employee Phone:"+e.getPhone());
			System.out.println("Email:"+e.getEmail());
			System.out.println("Employee salary:"+e.getSalary());
			System.out.println("Employee Designation:"+e.getDesg());
			System.out.println("-----*****-----");
		}
		catch(NoResultException e){
			System.out.println("You have entered an Invalid Phone and Password");
		}
	}
	public static void verifyEmpByEmailPassword() {
		System.out.println("Enter your Email and Password to verify");
		String email=s.next();
		String password=s.next();
		try {
		        Employee e=dao.VerifyEmployee(email, password);
				System.out.println("Employee Id:"+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("Employee Phone:"+e.getPhone());
				System.out.println("Email:"+e.getEmail());
				System.out.println("Employee salary:"+e.getSalary());
				System.out.println("Employee Designation:"+e.getDesg());
		}
		catch(NoResultException e){
			System.out.println("You have entered an Invalid Phone and Password");
		}
	}
	public static void verifyEmpByIdPassword() {
		System.out.println("Enter your Id and Password to verify");
		int id=s.nextInt();
		String password=s.next();
		try {
		    Employee e=dao.VerifyEmployee(id, password);
			System.out.println("Employee Id:"+e.getId());
			System.out.println("Employee Name:"+e.getName());
			System.out.println("Employee Phone:"+e.getPhone());
			System.out.println("Email:"+e.getEmail());
			System.out.println("Employee salary:"+e.getSalary());
			System.out.println("Employee Designation:"+e.getDesg());
		}
		catch(NoResultException e){
			System.out.println("You have entered an Invalid Id and Password");
		}
	}
	public static void deptById() {
		System.out.println("Enter your Id to display");
		int id = s.nextInt();
		Department d = dao1.findById(id);
		if (d != null) {
			System.out.println("User id:" + d.getId());
			System.out.println("Name:" + d.getName());
			System.out.println("Location:" + d.getLocation());
		} else {
			System.out.println("You have entered an Invalid Id");
		}
   }
}
