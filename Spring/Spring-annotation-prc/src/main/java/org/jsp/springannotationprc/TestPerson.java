package org.jsp.springannotationprc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class TestPerson {
  public static void main(String[] args) {   
	  ApplicationContext context=new AnnotationConfigApplicationContext("org.jsp.springannotationprc");
      Person p=context.getBean(Person.class);
      p.display();
  }
}
