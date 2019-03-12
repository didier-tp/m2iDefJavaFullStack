package com.m2i.tp.service;

public class MyServiceException extends RuntimeException {

	public MyServiceException() {
	}

	public MyServiceException(String message) {
		super(message);
	}

	public MyServiceException(Throwable cause) {
		super(cause);
	}

	public MyServiceException(String message, Throwable cause) {
		super(message, cause);
	}


}
