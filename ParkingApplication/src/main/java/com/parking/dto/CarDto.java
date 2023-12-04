package com.parking.dto;


public class CarDto {

	private int id;

	private String color;

	private String registrationNumber;

	public CarDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDto(int id, String color, String registrationNumber) {
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
		return "CarDto [id=" + id + ", color=" + color + ", registrationNumber=" + registrationNumber + "]";
	}
	
	


}
