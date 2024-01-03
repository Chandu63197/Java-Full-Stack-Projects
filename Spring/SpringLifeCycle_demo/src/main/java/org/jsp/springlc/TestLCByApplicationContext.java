package org.jsp.springlc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestLCByApplicationContext {
    public static void main(String[] args) {
	  ApplicationContext context=new ClassPathXmlApplicationContext("life-cycle.xml");
	  System.out.println(context.getBean(Demo.class));
	  System.out.println(context.getBean(Demo.class));
	  System.out.println(context.getBean(Demo.class));
	  ((ClassPathXmlApplicationContext) context).close();
   }
}
