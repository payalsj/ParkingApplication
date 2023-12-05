package com.parking.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.parking.dto.CarDto;
import com.parking.entity.Car;
import com.parking.entity.CarsAudit;
import com.parking.entity.ParkingSpot;
import com.parking.entity.Ticket;
import com.parking.repository.CarRepository;
import com.parking.repository.CarsAuditRepository;
import com.parking.repository.ParkingSpotRepository;
import com.parking.repository.TicketRepository;

@SpringBootTest
public class ParkingServiceImplTest {
	
	@InjectMocks
	ParkingSpotServiceImpl parkingSpotServiceImpl;
	
	@Mock
	ParkingSpotRepository parkingSpotRepository;
	
	@Mock
	CarRepository carRepository;
	
	@Mock
	TicketRepository ticketRepository;
	
	@Mock
	CarsAuditRepository carsAuditRepository;
	
	@Test
	public void test_getTicket(){
		CarDto carDto= CarDto.builder().id(9).color("Black").registrationNumber("Mh56").build();
		Car car= Car.builder().id(10).color("Black").registrationNumber("MH12K89").build();
		ParkingSpot parkingSpot= ParkingSpot.builder().spotId(1).spotNumber(1).car(car).build();
		Ticket ticket= Ticket.builder().ticketId(1).ticketNumber(5678).parkingSpot(parkingSpot).build();
		
		CarsAudit carsAudit = CarsAudit.builder().id(8).color("Pink").entryTime(new Date()).registrationNumber("Mh456").spotNumber(9).exitTime(null).build();
		Mockito.when(parkingSpotRepository.getNearestAvailableSpotForParking())
		.thenReturn(parkingSpot);
		
		Mockito.when(carRepository.findByRegistrationNumber(Mockito.any()))
		.thenReturn(null);
		
		Mockito.when(carRepository.save(Mockito.any()))
		.thenReturn(car);
		
		Mockito.when(parkingSpotRepository.save(Mockito.any()))
		.thenReturn(parkingSpot);
		
		Mockito.when(ticketRepository.save(Mockito.any()))
		.thenReturn(ticket);
		
		Mockito.when(carsAuditRepository.save(Mockito.any()))
		.thenReturn(carsAudit);
		
		assertNotNull(parkingSpotServiceImpl.getTicket(carDto));
	
	}
	
//	@Test
//	public void test_deleteByRegistrationNumber() {
//
//		Car car = Car.builder().id(10).color("Black").registrationNumber("MH12K89").build();
//		ParkingSpot parkingSpot = ParkingSpot.builder().spotId(1).spotNumber(1).car(car).build();
//		Ticket ticket = Ticket.builder().ticketId(1).ticketNumber(5678).parkingSpot(parkingSpot).build();
//		CarsAudit carsAudit = CarsAudit.builder().id(8).color("Pink").entryTime(new Date()).registrationNumber("Mh456")
//				.spotNumber(9).exitTime(null).build();
//
//		Mockito.when(carRepository.findByRegistrationNumber(Mockito.any())).thenReturn(car);
//
//		Mockito.when(parkingSpotRepository.findByCarId(Mockito.any())).thenReturn(parkingSpot);
//
//		Mockito.when(parkingSpotRepository.save(Mockito.any())).thenReturn(parkingSpot);
//
//		Mockito.when(ticketRepository.findByParkingSpot(Mockito.any())).thenReturn(ticket);
//
//		Mockito.doNothing().when(carRepository).delete(Mockito.any());
//		Mockito.doNothing().when(ticketRepository).delete(Mockito.any());
//
//		Mockito.when(carsAuditRepository.findByRegistrationNumber(Mockito.any())).thenReturn(carsAudit);
//
//		Mockito.when(carsAuditRepository.save(Mockito.any())).thenReturn(carsAudit);
//
//		parkingSpotServiceImpl.deleteByRegistrationNumber("MH12");
//
//		Mockito.verify(carsAuditRepository, Mockito.times(1)).save(Mockito.any());
//
//	}

}
