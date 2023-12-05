package com.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parking.dto.CarDto;
import com.parking.entity.Car;
import com.parking.entity.ParkingSpot;
import com.parking.entity.Ticket;
import com.parking.exception.ParkingNotAvailableException;
import com.parking.repository.CarRepository;
import com.parking.repository.ParkingSpotRepository;
import com.parking.repository.TicketRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private TicketRepository ticketRepository;

	public Ticket generateTicket() {
		return null;
	}

	public ResponseEntity<Ticket> getTicket(CarDto car) {

		ParkingSpot parkingSpot = parkingSpotRepository.getNearestAvailableSpotForParking();
		if (parkingSpot == null) {
			throw new ParkingNotAvailableException("Sorry , Parking is full");
		}

		Car car2 = Car.builder().registrationNumber(car.getRegistrationNumber()).color(car.getColor()).build();
		carRepository.save(car2);

		parkingSpot.setCar(car2);
		parkingSpotRepository.save(parkingSpot);

		Ticket ticket = Ticket.builder().parkingSpot(parkingSpot)
				.ticketNumber((int) (Math.random() * (200 - 100 + 1)) + 100).build();

		ticketRepository.save(ticket);
		return ResponseEntity.status(HttpStatus.CREATED).body(ticket);

	}

	@Transactional
	public void deleteByRegistrationNumber(String registrationNumber) {
		Car car = carRepository.findByRegistrationNumber(registrationNumber);
		if (car == null) {
			throw null;
		} else {
			ParkingSpot parkingSpot = parkingSpotRepository.findByCarId(car.getId());
			parkingSpot.setCar(null);
			parkingSpotRepository.save(parkingSpot);
			Ticket ticket=ticketRepository.findByParkingSpot(parkingSpot);
			ticket.setParkingSpot(null);
			carRepository.delete(car);

		}
	}
}
