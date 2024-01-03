package org.jsp.demoApp;

public class Test {
   public static void main(String[] args) {
	 try {
		 Class.forName("org.jsp.demoApp.Trainer");
	 }
	 catch(ClassNotFoundException e) {
		 e.printStackTrace();
	 }
   }
}
