package com.parking.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.parking.repository.TicketRepository;

@SpringBootTest
public class TicketServiceImplTest {

	@InjectMocks
	private TicketServiceImpl ticketServiceImpl;

	@Mock
	TicketRepository ticketRepository;

	@Test
	public void test_getTicketNumberByRegistrationNumber() {
		int ticketByRegistartionNumber = 567898;
		Mockito.when(ticketRepository.getTicketNumberByCarRegistrationNumber(Mockito.any()))
				.thenReturn(ticketByRegistartionNumber);
		assertNotNull(ticketServiceImpl.getTicketNumberByRegistrationNumber("Mh28177"));
	}

	@Test
	public void test_getTicketNumbersByCarColor() {
		List<Integer> ticketsByRegistarionNumber= new ArrayList<>();
		Mockito.when(ticketRepository.getTicketNumbersByCarColor(Mockito.any()))
				.thenReturn(ticketsByRegistarionNumber);
		assertNotNull(ticketServiceImpl.getTicketNumbersByCarColor("Black"));
	}
}
