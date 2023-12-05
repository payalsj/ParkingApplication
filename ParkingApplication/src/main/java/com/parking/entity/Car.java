package com.parking.entity;

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
@Table(name = "CAR")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

	@Column(name = "CAR_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "CAR_COLOR")
	private String color;

	@Column(name = "CAR_REGISTRAION_NUMBER")
	private String registrationNumber;

}
