package org.jsp.tightcoupling;

public class Car {
  private Engine e=new Engine();
  public void startEngine() {
    e.start();
  }
}
