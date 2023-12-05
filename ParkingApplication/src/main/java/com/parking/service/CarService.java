package com.parking.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CarService {
	public ResponseEntity<List<String>> getRegistartionNumbersOfCarByColor(String color);
}
