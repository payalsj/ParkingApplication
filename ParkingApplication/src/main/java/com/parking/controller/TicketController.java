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
import com.parking.service.ParkingSpotService;
import com.parking.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private ParkingSpotService parkingSpotService;

	@Operation(summary = " This Api returns a ticket number and we can park the car at given place", description = "This Api returns a ticket number and we can park the car at given place")
	@PostMapping("/tickets")
	public ResponseEntity<Ticket> getTicket(@RequestBody CarDto carDto) {
		Ticket ticket = parkingSpotService.getTicket(carDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(ticket);

	}

	@Operation(summary = " This Api will unpark the car from parking", description = "This Api will unpark the car from parking who has provided registration number")
	@DeleteMapping("/unpark/{registrationNumber}")
	public ResponseEntity<?> unparkCar(
			@Parameter(example = "MH12U789", description = "Provide car registrartion number to unpark car") @PathVariable("registrationNumber") String registrationNumber) {
		parkingSpotService.deleteByRegistrationNumber(registrationNumber);
		return ResponseEntity.status(HttpStatus.OK).body("Car unparked Sucessfully");
	}

	@Operation(summary = " This Api will return Ticket number in which a car with a given registration number is placed", description = "This Api will return Ticket number in which a car with a given registration number is placed")
	@GetMapping("/tickets/{registratonNumber}")
	public ResponseEntity<?> getTicketNumberByRegistartinNumber(
			@Parameter(example = "MH12U789", description = "Provide car registrartion number to unpark car") @PathVariable("registratonNumber") String registratonNumber) {
		Integer ticketNumber = ticketService.getTicketNumberByRegistrationNumber(registratonNumber);
		return ResponseEntity.status(HttpStatus.OK)
				.body("For car with Registration Number " + registratonNumber + " Ticket Number Is : " + ticketNumber);
	}

	@Operation(summary = " This Api will return List of Ticket numbers of all tickets where a car of a particular color is placed", description = "This Api will return List of Ticket numbers of all tickets where a car of a particular color is placed")
	@GetMapping("/tickets/color/{color}")
	public ResponseEntity<?> getTicketNumbersByCarColor(
			@Parameter(example = "Black", description = "Provide car color") @PathVariable("color") String color) {
		List<Integer> ticketNumbers = ticketService.getTicketNumbersByCarColor(color);
		return ResponseEntity.status(HttpStatus.OK).body(ticketNumbers);
	}

}
