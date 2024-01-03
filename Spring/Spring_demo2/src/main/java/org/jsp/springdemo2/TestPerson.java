package org.jsp.springdemo2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class TestPerson {
   public static void main(String[] args) {
	  Resource r=new ClassPathResource("person.xml");
	  BeanFactory factory=new XmlBeanFactory(r);
	  Person p=factory.getBean(Person.class);
	  p.display();
   }
}
