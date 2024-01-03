package org.jsp.springdemo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class Test {
  public static void main(String[] args) {
	Resource r=new ClassPathResource("car.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	Car c=(Car) factory.getBean("myCar");
	//Car c=factory.getBean(Car.class);
	//Car c=factory.getBean("myCar",Car.class);
	c.start();
  }
}
