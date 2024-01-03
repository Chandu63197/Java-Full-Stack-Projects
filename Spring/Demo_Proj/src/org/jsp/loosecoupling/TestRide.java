package org.jsp.loosecoupling;

public class TestRide {
   public static void main(String[] args) {
	 Ride r=new Ride();
	 r.setV(new Car());//Dependency Injection
	 r.getV().start();
   }
}
