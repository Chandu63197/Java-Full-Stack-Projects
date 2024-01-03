package org.jsp.springcidemo.constructor;
import org.jsp.springcidemo.setter.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {
	 public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("deptartment.xml");
		Department d=context.getBean(Department.class);
		System.out.println("Names:"+d.getNames());
		System.out.println("Phone Numbers:"+d.getPhones());
		System.out.println("Details:"+d.getDetails());
	 }
}
