package com.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.entity.Car;
import com.parking.service.ParkCarService;

@RestController
public class ParkingController {

	@Autowired
	private ParkCarService parkCarService;

	@PostMapping("/park/car")
	public void carDetails(@RequestBody Car car) {
		parkCarService.carDetails(car);

	}

}
