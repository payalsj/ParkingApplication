package com.parking.service;

import org.springframework.http.ResponseEntity;

public interface TicketService {

	ResponseEntity<?> getTicketNumberByRegistrationNumber(String registratonNumber);

	ResponseEntity<?> getTicketNumbersByCarColor(String color);

}
