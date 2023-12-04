package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
