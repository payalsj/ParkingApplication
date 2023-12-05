package com.parking.service;


import com.parking.dto.CarDto;
import com.parking.entity.Ticket;

public interface ParkingSpotService {
	
	
	public Ticket getTicket(CarDto car);

	public void deleteByRegistrationNumber(String registrationNumber);
	

}
