package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.entity.ParkingSpot;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {

	@Query(value = " SELECT ps FROM ParkingSpot ps WHERE ps.car IS NULL ORDER BY ps.spotNumber LIMIT 1")
	public ParkingSpot getNearestAvailableSpotForParking();

	public ParkingSpot findByCarId(int id);

	public void deleteByCarId(int id);

}
