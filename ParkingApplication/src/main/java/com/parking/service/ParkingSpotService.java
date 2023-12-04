package com.parking.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.entity.ParkingSpot;
import com.parking.entity.Ticket;
import com.parking.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;


	public Ticket generateTicket() {
		Ticket ticket = new Ticket();
		ticket.setParkingSpot(parkingSpotRepository.emptyParking());
		ticket.setTicketNumber((int) (Math.random() * (200 - 100 + 1)) + 100);
		return ticket;
	}

}
