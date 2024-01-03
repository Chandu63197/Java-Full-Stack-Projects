package org.jsp.springannotationprc1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Baby {
	@Autowired
	@Qualifier("chocolate")
	private IceCream icecream;

	public IceCream getIcecream() {
		return icecream;
	}

	public void setIcecream(IceCream icecream) {
		this.icecream = icecream;
	}
}
