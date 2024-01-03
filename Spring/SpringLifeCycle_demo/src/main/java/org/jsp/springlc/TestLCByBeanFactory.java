package org.jsp.springlc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class TestLCByBeanFactory {
   public static void main(String[] args) {
	  Resource r=new ClassPathResource("life-cycle.xml");
	  BeanFactory factory=new XmlBeanFactory(r);
      Demo d=factory.getBean(Demo.class);
	  System.out.println(factory.getBean(Demo.class));
	  System.out.println(factory.getBean(Demo.class));
      System.out.println(d);
   }
}
