package org.jsp.springlifecycledemo;

public class Test {
	static {
		System.out.println("Test class is loaded into the JVM Memory");
	}

	public Test() {
		System.out.println("Test() has been called");
	}

	public void hii() {
		System.out.println("Test is initialized");
	}

	public void byee() {
		System.out.println("Test is destroyed");
	}
}
