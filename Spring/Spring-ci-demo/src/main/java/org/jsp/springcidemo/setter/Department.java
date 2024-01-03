package org.jsp.springcidemo.setter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Department {
	private List<String> names;
	private Set<Long> phones;
	private Map<Long, String> details;

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Set<Long> getPhones() {
		return phones;
	}

	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}

	public Map<Long, String> getDetails() {
		return details;
	}

	public void setDetails(Map<Long, String> details) {
		this.details = details;
	}
}
