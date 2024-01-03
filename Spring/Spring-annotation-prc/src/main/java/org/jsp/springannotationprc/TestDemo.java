package org.jsp.springannotationprc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class TestDemo {
   public static void main(String[] args) {
	  ApplicationContext context=new AnnotationConfigApplicationContext("org.jsp.springannotationprc");
	  Demo d=context.getBean("myDemo",Demo.class);
	  d.test();
   }
}
