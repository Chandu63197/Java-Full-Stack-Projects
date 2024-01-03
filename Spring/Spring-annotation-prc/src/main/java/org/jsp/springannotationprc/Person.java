package org.jsp.springannotationprc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private int age;
    @Value(value="ABC")
    private String name;
    private long phone;
    public Person(@Value(value="9876543210") long phone) {
    	this.phone=phone;
    }
    public void display() {
    	System.out.println("Age:"+age);
    	System.out.println("Name:"+name);
    	System.out.println("Phone:"+phone);
    }
    public int getAge() {
		return age;
	}
    @Value(value="25")
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
