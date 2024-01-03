package org.jsp.adminbusspringproj.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String from_loc;
	@Column(nullable = false)
	private String to_loc;
	@Column(nullable = false)
	private LocalDate date_of_departure;
	@Column(nullable = false)
	private double cost_per_seat;
	@ManyToOne
	@JoinColumn
    private Admin admin;
    
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

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

	public String getFrom_loc() {
		return from_loc;
	}

	public void setFrom_loc(String from_loc) {
		this.from_loc = from_loc;
	}

	public String getTo_loc() {
		return to_loc;
	}

	public void setTo_loc(String to_loc) {
		this.to_loc = to_loc;
	}

	public LocalDate getDate_of_departure() {
		return date_of_departure;
	}

	public void setDate_of_departure(LocalDate date_of_departure) {
		this.date_of_departure = date_of_departure;
	}

	public double getCost_per_seat() {
		return cost_per_seat;
	}

	public void setCost_per_seat(double cost_per_seat) {
		this.cost_per_seat = cost_per_seat;
	}
}
