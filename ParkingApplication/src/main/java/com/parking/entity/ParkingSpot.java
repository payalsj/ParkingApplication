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
@Table(name = "PARKING_SPOT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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

	
}
