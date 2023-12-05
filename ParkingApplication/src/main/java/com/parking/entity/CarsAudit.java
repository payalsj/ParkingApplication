package com.parking.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CARS_AUDIT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
	public class CarsAudit {

	@Column(name = "AUDIT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;
	
	@Column(name = "SPOT_NUMBER")
	private int spotNumber;
	
	@Column(name = "CAR_COLOR")
	private String color;
	
	@Column(name = "TICKET_NUMBER")
	private int ticketNumber;
	

	@Column(name = "CAR_ENTER")
	private Date entryTime;

	@Column(name = "CAR_EXIT")
	private Date exitTime;
	
	

}
