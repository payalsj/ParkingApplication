package com.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dto.CarDto;
import com.parking.entity.Ticket;
import com.parking.service.ParkingSpotServiceImpl;

@RestController
public class ParkingController {

	@Autowired
	private ParkingSpotServiceImpl parkingSpotServic;

	@PostMapping("/park/car")
	public Ticket getTicket(@RequestBody CarDto car) {
		return parkingSpotServic.getTicket(car);

	}

	@GetMapping("/ticket")
	public Ticket getTicket() {
		return parkingSpotServic.generateTicket();

	}

}
