package com.gmail.kleinikov.stanislav.exception;

public class ServiceNoSuchUserException extends Exception {

	private static final long serialVersionUID = -9089071786911919243L;

	public ServiceNoSuchUserException() {
		super();
	}

	public ServiceNoSuchUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceNoSuchUserException(String message) {
		super(message);
	}

	public ServiceNoSuchUserException(Throwable cause) {
		super(cause);
	}
}
