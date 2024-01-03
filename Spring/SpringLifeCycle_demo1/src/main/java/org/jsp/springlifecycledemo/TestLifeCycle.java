package org.jsp.springlifecycledemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestLifeCycle {
   public static void main(String[] args) {
	  ApplicationContext context=new ClassPathXmlApplicationContext("life-cycle.xml");
	  ((ClassPathXmlApplicationContext)context).close();
   }
}
