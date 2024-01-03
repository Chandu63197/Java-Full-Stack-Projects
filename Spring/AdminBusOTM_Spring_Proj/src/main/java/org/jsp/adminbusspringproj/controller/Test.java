package org.jsp.adminbusspringproj.controller;

import org.jsp.adminbusspringproj.AdminBusConfig;
import org.jsp.adminbusspringproj.dto.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
   public static void main(String[] args) {
	  ApplicationContext context=new AnnotationConfigApplicationContext(AdminBusConfig.class);
	  Admin d=context.getBean(Admin.class);
	  d.getBus();
   }
}
