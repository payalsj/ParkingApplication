package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.parking.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@Operation(summary = " This Api returns registration numbers of all cars of a particular Color", description = "This Api returns registration numbers of all cars of a particular Color")
	@GetMapping("/cars/{color}")
	public ResponseEntity<List<String>> getRegistartionNumbersOfCarByColor(
			@Parameter(example = "Red", description = "Provide car color to get its registration Number") @PathVariable("color") String color) {
		List<String> listOfRegistartionNumbers = carService.getRegistartionNumbersOfCarByColor(color);
		return ResponseEntity.status(HttpStatus.OK).body(listOfRegistartionNumbers);
	}

}
