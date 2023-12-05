package com.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.exception.CarNotFound;
import com.parking.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	public List<String> getRegistartionNumbersOfCarByColor(String color) {
		List<String> listOfRegistartionNumbers = carRepository.getAllRegistrationNumbersOfCarByColor(color);
		if (listOfRegistartionNumbers.isEmpty()) {
			throw new CarNotFound("There is no car in Parking With color: " + color);
		}
		return listOfRegistartionNumbers;
	}
}
