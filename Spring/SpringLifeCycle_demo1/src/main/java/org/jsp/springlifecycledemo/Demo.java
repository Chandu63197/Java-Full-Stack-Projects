package org.jsp.springlifecycledemo;

public class Demo {
	static {
		System.out.println("Demo class is loaded into the JVM Memory");
	}

	public Demo() {
		System.out.println("Demo() has been called");
	}

	public void hii() {
		System.out.println("Demo is initialized");
	}

	public void byee() {
		System.out.println("Demo is destroyed");
	}
}
