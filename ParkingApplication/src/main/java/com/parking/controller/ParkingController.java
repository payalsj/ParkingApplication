package com.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.entity.Car;
import com.parking.entity.Ticket;
import com.parking.service.ParkCarService;
import com.parking.service.ParkingSpotService;

@RestController
public class ParkingController {

	@Autowired
	private ParkCarService parkCarService;
	
	@Autowired
	private ParkingSpotService parkingSpotServic;

	@PostMapping("/park/car")
	public void carDetails(@RequestBody Car car) {
		parkCarService.carDetails(car);

	}
	
	@GetMapping("/ticket")
	public Ticket getTicket() {
		return parkingSpotServic.generateTicket();
		
	}

}
