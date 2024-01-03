package org.jsp.springdidemo.constructor;
public class Person {
	private AadharCard card;
	public Person() {}
	public Person(AadharCard card) {
		this.card=card;
	}
	public AadharCard getCard() {
		return card;
	}
	public void setCard(AadharCard card) {
		this.card = card;
	}
}
