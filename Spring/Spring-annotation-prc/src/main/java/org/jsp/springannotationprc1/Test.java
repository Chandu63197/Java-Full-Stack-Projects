package org.jsp.springannotationprc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
   public static void main(String[] args) {
	  ApplicationContext context=new AnnotationConfigApplicationContext("org.jsp.springannotationprc1");
	  Baby b=context.getBean(Baby.class);
	  b.getIcecream().eat();
   }
}
