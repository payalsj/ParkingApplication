package com.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket {
	
	@Id
	@Column(name = "TICKET_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	
	@Column(name = "TICKET_NUMBER")
	private int ticketNumber;
	
	@OneToOne
	@JoinColumn(name = "PARKING_SPOT")
	private ParkingSpot parkingSpot;
	
	
	public Ticket(int ticketId, int ticketNumber, ParkingSpot parkingSpot) {
		super();
		this.ticketId = ticketId;
		this.ticketNumber = ticketNumber;
		this.parkingSpot = parkingSpot;
	}
	public Ticket() {
		super();
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketNumber=" + ticketNumber + ", parkingSpot=" + parkingSpot + "]";
	}
	

}
