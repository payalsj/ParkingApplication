package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dto.CarDto;
import com.parking.entity.Ticket;
import com.parking.service.CarService;
import com.parking.service.ParkingSpotService;
import com.parking.service.ParkingSpotServiceImpl;

@RestController
public class TicketController {

	@Autowired
	private ParkingSpotService parkingSpotServic;
	
	@PostMapping("/tickets")
	public ResponseEntity<Ticket> getTicket(@RequestBody CarDto car) {
		return parkingSpotServic.getTicket(car);

	}

	@DeleteMapping("/unpark/{registrationNumber}")
	public ResponseEntity<Void> unparkCar(@PathVariable("registrationNumber") String registrationNumber) {

		return parkingSpotServic.deleteByRegistrationNumber(registrationNumber);
	}


}
