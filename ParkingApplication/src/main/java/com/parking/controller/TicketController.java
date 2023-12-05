package com.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dto.CarDto;
import com.parking.entity.Ticket;
import com.parking.service.ParkingSpotServiceImpl;

@RestController
public class TicketController {

	@Autowired
	private ParkingSpotServiceImpl parkingSpotServic;

	@PostMapping("/tickets")
	public ResponseEntity<Ticket> getTicket(@RequestBody CarDto car) {
		return parkingSpotServic.getTicket(car);

	}

	@DeleteMapping("/unpark/{registrationNumber}")
	public void unparkCar(@PathVariable("registrationNumber") String registrationNumber) {

		parkingSpotServic.deleteByRegistrationNumber(registrationNumber);
	}

}
