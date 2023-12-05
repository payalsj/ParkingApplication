package com.parking.exception;

public class ParkingNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParkingNotAvailableException() {
		super();
	}

	public ParkingNotAvailableException(String message) {
		super(message);
	}

}
