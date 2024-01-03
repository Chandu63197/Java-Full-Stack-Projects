package org.jsp.springlc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Demo implements InitializingBean, DisposableBean {
	static {
		System.out.println("Demo class is loaded into JVM Memory");
	}
	public void display() {
		System.out.println("It is display() of demo");
	}
	public Demo() {
		System.out.println("Demo Object is getting created");
	}
	public void destroy() throws Exception {
        System.out.println("Demo Object is destroyed"); 
	}
	public void afterPropertiesSet() throws Exception {
        System.out.println("Demo Object is initialized");
	}
}
