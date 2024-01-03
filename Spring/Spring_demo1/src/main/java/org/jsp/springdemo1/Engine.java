package org.jsp.springdemo1;
public class Engine {
	private int cc;
	private int no_of_cyl;
	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getNo_of_cyl() {
		return no_of_cyl;
	}

	public void setNo_of_cyl(int no_of_cyl) {
		this.no_of_cyl = no_of_cyl;
	}

	public void display() {
		System.out.println("cc:" + cc);
		System.out.println("No_of_Cylinders:" + no_of_cyl);
	}
}
