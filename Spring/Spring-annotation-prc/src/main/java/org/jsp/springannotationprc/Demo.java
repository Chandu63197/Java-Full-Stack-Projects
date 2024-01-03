package org.jsp.springannotationprc;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Component(value="myDemo")
//@Repository(value="myDemo")
//@Service(value="myDemo")
//@Controller(value="myDemo")
public class Demo {
   public void test() {
	   System.out.println("Demo class is tested");
   }
}
