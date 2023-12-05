package com.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dto.CarDto;
import com.parking.entity.Ticket;
import com.parking.repository.AuditRepository;
import com.parking.service.ParkingSpotService;
import com.parking.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

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
	
	// Ticket number in which a car with a given registration number is placed
	
	@GetMapping("/tickets/{registratonNumber}")
	public ResponseEntity<?> getTicketNumberByRegistartinNumber(@PathVariable("registratonNumber") String registratonNumber) {

		return ticketService.getTicketNumberByRegistrationNumber(registratonNumber);
	}

	//Ticket numbers of all tickets where a car of a particular color is placed
	@GetMapping("/tickets/color/{color}")
	public ResponseEntity<?> getTicketNumbersByCarColor(@PathVariable("color") String color) {

		return ticketService.getTicketNumbersByCarColor(color);
	}


}
