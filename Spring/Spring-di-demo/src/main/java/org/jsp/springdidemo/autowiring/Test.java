package org.jsp.springdidemo.autowiring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {
   public static void main(String[] args) {
	 ApplicationContext context=new ClassPathXmlApplicationContext("autowiring-demo.xml");
	 Ride r=context.getBean(Ride.class);
	 r.getV().start();
   }
}
