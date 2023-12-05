package com.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parking.entity.Car;
import com.parking.entity.ParkingSpot;
import com.parking.entity.Ticket;
import com.parking.exception.CarNotFound;
import com.parking.repository.CarRepository;
import com.parking.repository.ParkingSpotRepository;
import com.parking.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public ResponseEntity<?> getTicketNumberByRegistrationNumber(String registratonNumber) {

		Car car = carRepository.findByRegistrationNumber(registratonNumber);
		if(car== null) {
			throw new CarNotFound("No Car Found with Registartion Number : "+ registratonNumber);
		}

		ParkingSpot parkingSpot = parkingSpotRepository.findByCarId(car.getId());

		Ticket ticket = ticketRepository.findByParkingSpot(parkingSpot);

		return ResponseEntity.status(HttpStatus.OK).body("For car with Registration Number "+ registratonNumber+ " Ticket Number Is : "+ticket.getTicketNumber());
	}

}
