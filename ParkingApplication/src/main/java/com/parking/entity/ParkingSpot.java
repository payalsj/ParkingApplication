package com.parking.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARKING_SPOT")
public class ParkingSpot {

	@Id
	@Column(name = "SPOT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int spotId;

	@Column(name = "SPOT_NUMBER")
	private int spotNumber;

	@OneToOne
	@JoinColumn(name = "CAR_ID")
	private Car car;

	public ParkingSpot() {
		super();
	}

	public ParkingSpot(int spotId, Car car, int spotNumber) {
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
