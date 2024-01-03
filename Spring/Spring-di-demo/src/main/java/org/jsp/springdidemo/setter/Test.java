package org.jsp.springdidemo.setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
public class Test {
  public static void main(String[] args) {
//	ApplicationContext context=new ClassPathXmlApplicationContext("car-engine.xml");
//	Car c=context.getBean("myCar",Car.class);
//	c.getE().start();
	 
	ApplicationContext context=new FileSystemXmlApplicationContext("C:\\Users\\Chandu Naidu\\Desktop\\Spring\\Spring-di-demo\\src\\main\\resources\\car-engine.xml");
	Car c=context.getBean("myCar",Car.class);
	c.getE().start();
  }
}
