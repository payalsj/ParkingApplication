package com.parking.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.parking.repository.CarRepository;

@SpringBootTest
public class CarServiceImplTest {

	@InjectMocks
	private CarServiceImpl carServiceImpl;

	@Mock
	private CarRepository carRepository;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void test_getRegistartionNumbersOfCarByColor() {
		List<String> listOfRegistartionNumbers = new ArrayList<>();
		listOfRegistartionNumbers.add("MH22AG8430");
		Mockito.when(carRepository.getAllRegistrationNumbersOfCarByColor(Mockito.any()))
				.thenReturn(listOfRegistartionNumbers);
		assertNotNull(carServiceImpl.getRegistartionNumbersOfCarByColor("BLACK"));
	}

	@Test
	public void test_getRegistartionNumbersOfCarByColor_emptyList() {
		List<String> listOfRegistartionNumbers = new ArrayList<>();
		Mockito.when(carRepository.getAllRegistrationNumbersOfCarByColor(Mockito.any()))
				.thenReturn(listOfRegistartionNumbers);
		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> carServiceImpl.getRegistartionNumbersOfCarByColor("BLACK"),
				"There is no car in Parking With color: BLACK");
		assertTrue(thrown.getMessage().contains("There is no car in Parking With color: BLACK"));
	}

}
