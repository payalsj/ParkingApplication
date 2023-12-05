package com.parking.entity;

import java.time.LocalDate;
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
@Table(name = "AUDIT_CARS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuditCars {

	@Column(name = "AUDIT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private String registrationNumber;

	@Column(name = "CAR_ENTER")
	private Date entryTime;

	@Column(name = "CAR_EXIT")
	private Date exitTime;
	
	

}
