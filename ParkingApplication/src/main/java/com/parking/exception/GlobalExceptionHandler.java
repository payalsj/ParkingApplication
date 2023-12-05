package com.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	

		@ExceptionHandler(ParkingNotAvailableException.class)
		public ResponseEntity<?> parkingNotAvailable(ParkingNotAvailableException exceptio) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptio.getMessage());
		}

		
		@ExceptionHandler(NoRegistartionNumberFoundWithColor.class)
		public ResponseEntity<?> carNotFound(NoRegistartionNumberFoundWithColor exceptio) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptio.getMessage());
		}

}
