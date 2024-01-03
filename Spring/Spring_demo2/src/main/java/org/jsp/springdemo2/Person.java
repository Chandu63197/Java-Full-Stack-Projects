package org.jsp.springdemo2;

public class Person {
	private int age;
	private String name;
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public Person() {
		System.out.println("person() called");
	}
	public void display() {
		System.out.println("Age:"+age);
		System.out.println("Name:"+name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
