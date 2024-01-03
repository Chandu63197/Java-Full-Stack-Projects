package org.jsp.springannotationprc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Car {
	//@Autowired
	private Engine e;
	public Engine getE() {
		return e;
	}
	@Autowired
	public void setE(Engine e) {
		this.e = e;
	}
    
	//public Car() {}
	//@Autowired
	public Car(@Autowired Engine e) {
		this.e=e;
	}
}
