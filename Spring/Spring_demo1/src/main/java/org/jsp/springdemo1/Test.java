package org.jsp.springdemo1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class Test {
  public static void main(String[] args) {
	Resource r=new ClassPathResource("engine.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	Engine e=(Engine) factory.getBean("myEngine");
	//Engine e=factory.getBean(Engine.class);
	//Engine e=factory.getBean("myEngine",Engine.class);
	e.display();
  }
}
