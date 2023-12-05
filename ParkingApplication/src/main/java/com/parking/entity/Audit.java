//package com.parking.entity;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "AUDIT")
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Audit {
//
//	@Column(name = "AUDIT_ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Id
//	private int id;
//
//	@Column(name = "ENTRY")
//	private LocalDate entry;
//
//	@Column(name = "EXIT")
//	private LocalDate exit;
//	
//	
//
//}
