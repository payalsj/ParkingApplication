package com.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "SPOT")
public class Spot {

	@Id
	@Column(name = "SPOT_ID")
	private int spotId;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Car car;

	@Column(name = "SPOT_NUMBER")
	private int spotNumber;

	public Spot() {
		super();
	}

	public Spot(int spotId, Car car, int spotNumber) {
		super();
		this.spotId = spotId;
		this.car = car;
		this.spotNumber = spotNumber;
	}

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}

	@Override
	public String toString() {
		return "Spot [spotId=" + spotId + ", car=" + car + ", spotNumber=" + spotNumber + "]";
	}

}
