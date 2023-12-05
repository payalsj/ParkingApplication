package com.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TICKET")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}
