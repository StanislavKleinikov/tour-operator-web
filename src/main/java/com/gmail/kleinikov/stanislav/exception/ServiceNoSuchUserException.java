package com.gmail.kleinikov.stanislav.exception;

import java.io.Serializable;

public class ServiceNoSuchUserException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

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
