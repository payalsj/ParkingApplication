package com.parking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dto.CarDto;
import com.parking.entity.Car;
import com.parking.entity.CarsAudit;
import com.parking.entity.ParkingSpot;
import com.parking.entity.Ticket;
import com.parking.exception.CarAlreadyEnteredException;
import com.parking.exception.CarNotFound;
import com.parking.exception.ParkingNotAvailableException;
import com.parking.repository.CarRepository;
import com.parking.repository.CarsAuditRepository;
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

	@Autowired
	private CarsAuditRepository auditRepository;

	@Transactional
	public Ticket getTicket(CarDto carDto) {
		ParkingSpot parkingSpot = parkingSpotRepository.getNearestAvailableSpotForParking();
		if (parkingSpot == null) {
			throw new ParkingNotAvailableException("Sorry , Parking is full");
		}
		if (carRepository.findByRegistrationNumber(carDto.getRegistrationNumber()) != null) {
			throw new CarAlreadyEnteredException("Car is already present in parking spot.");
		}
		Car car = carRepository.save(
				Car.builder().registrationNumber(carDto.getRegistrationNumber()).color(carDto.getColor()).build());
		parkingSpot.setCar(car);
		parkingSpotRepository.save(parkingSpot);
		Ticket ticket = Ticket.builder().parkingSpot(parkingSpot)
				.ticketNumber((int) (Math.random() * (100000 - 50000 + 1)) + 50000).build();
		ticketRepository.save(ticket);
		CarsAudit audit = CarsAudit.builder().registrationNumber(car.getRegistrationNumber()).entryTime(new Date())
				.color(car.getColor()).registrationNumber(car.getRegistrationNumber())
				.ticketNumber(ticket.getTicketNumber()).spotNumber(parkingSpot.getSpotNumber()).build();
		auditRepository.save(audit);
		return ticket;
	}

	@Transactional
	public void deleteByRegistrationNumber(String registrationNumber) {
		Car car = carRepository.findByRegistrationNumber(registrationNumber);
		if (car == null) {
			throw new CarNotFound("Car Not Found");
		} else {
			ParkingSpot parkingSpot = parkingSpotRepository.findByCarId(car.getId());
			parkingSpot.setCar(null);
			parkingSpotRepository.save(parkingSpot);
			Ticket ticket = ticketRepository.findByParkingSpot(parkingSpot);
			carRepository.delete(car);
			ticketRepository.delete(ticket);
			CarsAudit audit = auditRepository.findByRegistrationNumber(car.getRegistrationNumber());
			audit.setExitTime(new Date());
			auditRepository.save(audit);
		}

	}

}
