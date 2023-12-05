package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.parking.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/cars/{color}")
	public ResponseEntity<List<String>> getRegistartionNumbersOfCarByColor(@PathVariable("color") String color) {

		return carService.getRegistartionNumbersOfCarByColor(color);
	}

}
