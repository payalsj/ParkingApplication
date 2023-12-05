package com.parking.service;

import java.util.List;

public interface TicketService {

	Integer getTicketNumberByRegistrationNumber(String registratonNumber);

	List<Integer> getTicketNumbersByCarColor(String color);

}
