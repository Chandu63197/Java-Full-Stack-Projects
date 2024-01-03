package org.jsp.springdidemo.constructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {
  public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("person-card.xml");
	Person p1=context.getBean("myPerson",Person.class);
	p1.getCard().display();
	Person p2=context.getBean("person",Person.class);
	p2.getCard().display();
  }
}
