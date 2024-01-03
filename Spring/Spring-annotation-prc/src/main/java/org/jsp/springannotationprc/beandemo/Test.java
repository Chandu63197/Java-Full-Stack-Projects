package org.jsp.springannotationprc.beandemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
   public static void main(String[] args) {
 	  ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
 	  Department d=context.getBean(Department.class);
 	  System.out.println("Name:"+d.getNames());
 	  System.out.println("Ids:"+d.getIds());
   }
}
