package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.entity.CarsAudit;

@Repository
public interface CarsAuditRepository extends JpaRepository<CarsAudit, Integer> {

	CarsAudit findByRegistrationNumber(String registrationNumber);

}
