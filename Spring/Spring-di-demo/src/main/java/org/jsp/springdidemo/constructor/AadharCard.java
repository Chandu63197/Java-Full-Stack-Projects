package org.jsp.springdidemo.constructor;

public class AadharCard {
	private String name;
	private long number;
	public void display() {
		System.out.println("Name:" + name);
		System.out.println("AadharNumber:" + number);
		System.out.println("--------***--------");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
}
