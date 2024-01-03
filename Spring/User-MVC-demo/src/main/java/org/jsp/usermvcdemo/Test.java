package org.jsp.usermvcdemo;

import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	@RequestMapping("/test")
	@ResponseBody
	public String hello() {
		return "Hello from Test Class";
	}
	
	@RequestMapping("/test-db-cfg")
	@ResponseBody
	public String testDatabaseConfiguration() {
		return Persistence.createEntityManagerFactory("dev").toString();
	}
}
