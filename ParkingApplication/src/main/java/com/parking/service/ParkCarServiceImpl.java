package com.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.entity.Car;
import com.parking.repository.CarRepository;
import com.parking.repository.ParkingSpotRepository;

@Service
public class ParkCarServiceImpl implements ParkCarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;

	@Override
	public void carDetails(Car car) {

		carRepository.save(car);

	}

}
