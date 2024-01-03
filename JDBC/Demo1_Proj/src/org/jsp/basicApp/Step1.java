package org.jsp.basicApp;

public class Step1 {
   public static void main(String[] args) {
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver class is loaded and Registered");
	 } catch (ClassNotFoundException e) {
		e.printStackTrace();
	 }
   }
}
