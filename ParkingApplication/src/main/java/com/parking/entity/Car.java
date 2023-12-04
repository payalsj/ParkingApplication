package com.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "CAR")
@Builder
public class Car {

	@Column(name = "CAR_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "CAR_COLOR")
	private String color;

	@Column(name = "CAR_REGISTRAION_NUMBER")
	private String registrationNumber;

	public Car() {
		super();
	}

	public Car(int id, String color, String registrationNumber) {
		super();
		this.id = id;
		this.color = color;
		this.registrationNumber = registrationNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", color=" + color + ", registrationNumber=" + registrationNumber + "]";
	}

}
