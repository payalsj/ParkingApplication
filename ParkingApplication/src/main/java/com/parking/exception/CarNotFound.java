package com.parking.exception;

public class CarNotFound extends RuntimeException {

	public CarNotFound() {
		super();
	}

	public CarNotFound(String message) {
		super(message);
	}

}
