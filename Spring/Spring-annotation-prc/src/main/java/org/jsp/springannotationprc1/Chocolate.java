package org.jsp.springannotationprc1;

import org.springframework.stereotype.Component;

@Component
public class Chocolate implements IceCream
{
	public void eat() {
		System.out.println("Baby is eating Chocolate IceCream");
	}
}
