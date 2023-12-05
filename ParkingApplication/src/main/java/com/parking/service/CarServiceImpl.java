package com.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parking.exception.NoRegistartionNumberFoundWithColor;
import com.parking.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	public ResponseEntity<List<String>> getRegistartionNumbersOfCarByColor(String color) {

		List<String> listOfRegistartionNumbers=carRepository.getAllRegistrationNumbersOfCarByColor(color);
		if(listOfRegistartionNumbers.isEmpty()) {
			throw new NoRegistartionNumberFoundWithColor("There is no car in Parking With color: "+color);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listOfRegistartionNumbers);
	}
}
