package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.entity.AuditCars;

public interface AuditRepository extends JpaRepository<AuditCars, Integer> {

	AuditCars findByRegistrationNumber(String registrationNumber);

}
