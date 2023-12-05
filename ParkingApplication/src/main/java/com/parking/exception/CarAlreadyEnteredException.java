package com.parking.exception;

public class CarAlreadyEnteredException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CarAlreadyEnteredException() {
		super();
	}

	public CarAlreadyEnteredException(String message) {
		super(message);
	}

}
