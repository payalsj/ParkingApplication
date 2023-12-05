package com.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.entity.ParkingSpot;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {

	@Query(nativeQuery = true, value = " select * from parking_spot where CAR_ID is null order by SPOT_NUMBER limit 1;")
	public ParkingSpot getNearestAvailableSpotForParking();

	public ParkingSpot findByCarId(int id);

	public void deleteByCarId(int id);

}
