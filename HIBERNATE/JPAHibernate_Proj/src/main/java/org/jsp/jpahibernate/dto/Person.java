package org.jsp.jpahibernate.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name="findByName",query="select p from Person p where p.name=?1")
@NamedQueries(value={
		@NamedQuery(name="verifyPersonByIdandPassword",query="select p from Person p where p.id=?1 and p.password=?2"),
		@NamedQuery(name="verifyPersonByPhoneandPassword",query="select p from Person p where p.phone=?1 and p.password=?2"),
		@NamedQuery(name="findByPhone",query="select p from Person p where p.phone=?1"),
		@NamedQuery(name="findByEmail",query="select p from Person p where p.email=?1"),
		@NamedQuery(name="verifyPersonByIdandName",query="select p from Person p where p.id=?1 and p.name=?2"),
		@NamedQuery(name="verifyPersonByAgeandName",query="select p from Person p where p.age=?1 and p.name=?2"),
		@NamedQuery(name="verifyPersonByPhoneandName",query="select p from Person p where p.phone=?1 and p.name=?2"),
		@NamedQuery(name="verifyPersonByEmailandName",query="select p from Person p where p.email=?1 and p.name=?2"),
		@NamedQuery(name="verifyPersonByEmailandPassword",query="select p from Person p where p.email=?1 and p.password=?2")
		})
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false, unique = true)
	private long phone;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
