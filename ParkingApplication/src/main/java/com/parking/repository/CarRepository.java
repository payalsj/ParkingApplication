package com.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	void deleteByRegistrationNumber(String registrationNumber);

	Car findByRegistrationNumber(String registrationNumber);

	@Query(value = "SELECT c.registrationNumber FROM Car c WHERE c.color= :color")
	List<String> getAllRegistrationNumbersOfCarByColor(String color);

	List<Car> findAllByColor(String color);

}
