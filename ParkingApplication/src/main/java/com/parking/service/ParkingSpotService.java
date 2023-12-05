package com.parking.service;


import org.springframework.http.ResponseEntity;

import com.parking.dto.CarDto;
import com.parking.entity.Ticket;

public interface ParkingSpotService {
	
	public Ticket generateTicket();
	
	public ResponseEntity<Ticket> getTicket(CarDto car);
	public ResponseEntity<Void> deleteByRegistrationNumber(String registrationNumber);
	

}
