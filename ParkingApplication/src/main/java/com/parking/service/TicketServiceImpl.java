package com.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Integer getTicketNumberByRegistrationNumber(String registratonNumber) {
		Integer ticketNumber = ticketRepository.getTicketNumberByCarRegistrationNumber(registratonNumber);
		return ticketNumber;
	}

	@Override
	public List<Integer> getTicketNumbersByCarColor(String color) {
		List<Integer> ticketNumbers = ticketRepository.getTicketNumbersByCarColor(color);
		return ticketNumbers;
	}

}
