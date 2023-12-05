package com.parking.exception;

public class CarNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CarNotFound() {
		super();
	}

	public CarNotFound(String message) {
		super(message);
	}

}
