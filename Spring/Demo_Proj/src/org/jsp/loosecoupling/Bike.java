package org.jsp.loosecoupling;

public class Bike implements Vehicle
{
  @Override
  public void start() {
	System.out.println("Bike has been started");
  }
}
