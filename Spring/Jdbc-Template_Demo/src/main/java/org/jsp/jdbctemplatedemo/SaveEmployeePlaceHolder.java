package org.jsp.jdbctemplatedemo;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployeePlaceHolder {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee id,name,desg and salary");
		int id=sc.nextInt();
		String name=sc.next();
		String desg=sc.next();
		double salary=sc.nextDouble();
		String qry="insert into employee values(?,?,?,?)";
		ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template=context.getBean(JdbcTemplate.class);
		int r=template.update(qry, id,name,desg,salary);
		System.out.println(r+" rows inserted ");
	}
}
