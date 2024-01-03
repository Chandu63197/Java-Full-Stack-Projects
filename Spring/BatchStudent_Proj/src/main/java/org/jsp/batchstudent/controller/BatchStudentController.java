package org.jsp.batchstudent.controller;

import java.util.List;
import java.util.Scanner;
import org.jsp.batchstudent.BatchStudentConfig;
import org.jsp.batchstudent.dao.BatchDao;
import org.jsp.batchstudent.dao.StudentDao;
import org.jsp.batchstudent.dto.Batch;
import org.jsp.batchstudent.dto.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BatchStudentController {
	static BatchDao dao;
	static StudentDao dao1;
	static ApplicationContext context;
	static Scanner sc = new Scanner(System.in);
	static {
		context = new AnnotationConfigApplicationContext(BatchStudentConfig.class);
		dao = context.getBean(BatchDao.class);
		dao1 = context.getBean(StudentDao.class);
	}

	public static void main(String[] args) {
		boolean b = true;
		while (b) {
			System.out.println("1.Save Batch");
			System.out.println("2.Update Batch");
			System.out.println("3.Add Student");
			System.out.println("4.Update Student");
			System.out.println("5.Find Students By Batch Id");
			System.out.println("6.Find Students By Batch code");
			System.out.println("7.Find Students By Batch subject");
			System.out.println("8.Find Batches By Student Id");
			System.out.println("5.Find Batches By Student Phone");
			System.out.println("5.Find Students By Batch trainer");
			System.out.println("Enter Your Choice");
			switch (sc.nextInt()) {
			case 1: {
				saveBatch();
				break;
			}
			case 2: {
				updateBatch();
				break;
			}
			case 3: {
				addStudent();
				break;
			}
			case 4: {
				updateStudent();
				break;
			}
			case 5: {
				findStudByBatchId();
				break;
			}
			case 6: {
				findStudByBatchCode();
				break;
			}
			case 7: {
				findStudByBatchSubject();
				break;
			}
			case 8: {
				findBatchByStudId();
				break;
			}
			case 9: {
				findBatchByStudPhone();
				break;
			}
			case 10: {
				findStudByBatchTrainer();
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

	public static void saveBatch() {
		System.out.println("Enter Your code,subject,trainer to register");
		Batch b = new Batch();
		b.setBatchcode(sc.next());
		b.setSubject(sc.next());
		b.setTrainer(sc.next());
		b = dao.saveBatch(b);
		System.out.println("Batch saved with Id:" + b.getId());
	}

	public static void updateBatch() {
		System.out.println("Enter the Batch Id to update");
		int id = sc.nextInt();
		System.out.println("Enter Your code,subject,trainer to register");
		Batch b = new Batch();
		b.setId(id);
		b.setBatchcode(sc.next());
		b.setSubject(sc.next());
		b.setTrainer(sc.next());
		b = dao.updateBatch(b);
		System.out.println("Batch updated with Id:" + b.getId());
	}

	public static void addStudent() {
		Student s = new Student();
		System.out.println("Enter the Batch id to add Student");
		int bid = sc.nextInt();
		System.out.println("Enter the name,phone,age,percentage");
		s.setName(sc.next());
		s.setPhone(sc.nextLong());
		s.setAge(sc.nextInt());
		s.setPercentage(sc.nextDouble());
		s = dao1.addStudent(s, bid);
		if (s != null)
			System.out.println("Student add with Id:" + s.getId());
		else
			System.err.println("Invalid Batch Id");
	}

	public static void updateStudent() {
		Student s = new Student();
		System.out.println("Enter the Batch id to update Student");
		int bid = sc.nextInt();
		System.out.println("Enter the name,phone,age,percentage");
		s.setId(sc.nextInt());
		s.setName(sc.next());
		s.setPhone(sc.nextLong());
		s.setAge(sc.nextInt());
		s.setPercentage(sc.nextDouble());
		s = dao1.updateStudent(s, bid);
		if (s != null)
			System.out.println("Student updated with Id:" + s.getId());
		else
			System.err.println("Invalid Batch Id");
	}

	public static void findStudByBatchId() {
		System.out.println("Enter the batch id to fetch Student details");
		int id = sc.nextInt();
		List<Student> students = dao1.findByBatchId(id);
		if (students.size() > 0) {
			for (Student s : students) {
				System.out.println("Student Id:" + s.getId());
				System.out.println("Student Name:" + s.getName());
				System.out.println("Student Phone:" + s.getPhone());
				System.out.println("Student Age:"+s.getAge());
				System.out.println("Student Perc:" + s.getPercentage());
				System.out.println("----------");
			}
		} else {
			System.out.println("Entered an Invalid Batch Id");
		}
	}

	public static void findStudByBatchCode() {
		System.out.println("Enter the batch code to fetch Student details");
		String code = sc.next();
		List<Student> students = dao1.findByBatchCode(code);
		if (students.size() > 0) {
			for (Student s : students) {
				System.out.println("Student Id:" + s.getId());
				System.out.println("Student Name:" + s.getName());
				System.out.println("Student Phone:" + s.getPhone());
				System.out.println("Student Age:"+s.getAge());
				System.out.println("Student Perc:" + s.getPercentage());
				System.out.println("----------");
			}
		} else {
			System.out.println("Entered an Invalid Batch Code");
		}
	}

	public static void findStudByBatchSubject() {
		System.out.println("Enter the batch Subject to fetch Student details");
		String subject = sc.next();
		List<Student> students = dao1.findBySubject(subject);
		if (students.size() > 0) {
			for (Student s : students) {
				System.out.println("Student Id:" + s.getId());
				System.out.println("Student Name:" + s.getName());
				System.out.println("Student Phone:" + s.getPhone());
				System.out.println("Student Age:"+s.getAge());
				System.out.println("Student Perc:" + s.getPercentage());
				System.out.println("----------");
			}
		} else {
			System.out.println("Entered an Invalid Batch Subject");
		}
	}

	public static void findBatchByStudId() {
		System.out.println("Enter the student id to fetch batch details");
		int id = sc.nextInt();
		List<Batch> batches = dao.findByStudentId(id);
		if (batches.size() > 0) {
			for (Batch b : batches) {
				System.out.println("Batch Id:" + b.getId());
				System.out.println("Batch Subject:" + b.getSubject());
				System.out.println("Batch Code:" + b.getBatchcode());
				System.out.println("Batch Trainer:"+b.getTrainer());
				System.out.println("----------");
			}
		} else {
			System.out.println("Entered an Invalid Student id");
		}
	}

	public static void findBatchByStudPhone() {
		System.out.println("Enter the student phone to fetch batch details");
		long phone = sc.nextLong();
		List<Batch> batches = dao.findByStudentPhone(phone);
		if (batches.size() > 0) {
			for (Batch b : batches) {
				System.out.println("Batch Id:" + b.getId());
				System.out.println("Batch Subject:" + b.getSubject());
				System.out.println("Batch Code:" + b.getBatchcode());
				System.out.println("Batch Trainer:"+b.getTrainer());
				System.out.println("----------");
			}
		} else {
			System.out.println("Entered an Invalid Student phone");
		}
	}

	public static void findStudByBatchTrainer() {
		System.out.println("Enter the batch trainer to fetch Student details");
		String trainer = sc.next();
		List<Student> students = dao1.findByBatchTrainer(trainer);
		if (students.size() > 0) {
			for (Student s : students) {
				System.out.println("Student Id:" + s.getId());
				System.out.println("Student Name:" + s.getName());
				System.out.println("Student Phone:" + s.getPhone());
				System.out.println("Student Age:"+s.getAge());
				System.out.println("Student Perc:" + s.getPercentage());
				System.out.println("----------");
			}
		} else {
			System.out.println("Entered an Invalid Batch Subject");
		}
	}
}
