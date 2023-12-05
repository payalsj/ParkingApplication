package com.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.entity.ParkingSpot;
import com.parking.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	Ticket findByParkingSpot(ParkingSpot spotId);

	@Query(nativeQuery = true, value = "SELECT t.ticket_number " + "FROM ticket t " + "LEFT JOIN parking_spot ps "
			+ "ON ps.SPOT_ID  = t.parking_spot " + "LEFT JOIN car c " + "ON c.car_id  = ps.CAR_ID "
			+ "where c.car_registraion_number = :registrationNumber " + ";")
	Integer getTicketNumberByCarRegistrationNumber(String registrationNumber);

	@Query(nativeQuery = true, value = "select ticket_number from ticket t where  t.parking_spot in (select ps.SPOT_ID  from parking_spot ps where ps.CAR_ID in (select c.car_id  from car  c where c.car_color= :color));")
	List<Integer> getTicketNumbersByCarColor(String color);
}
