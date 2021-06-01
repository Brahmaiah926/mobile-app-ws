package com.appsdevlopersblog.app.ws.exceptions;

public class UserServiceException extends RuntimeException{

	private static final long serialVersionUID = 1232445445464L;
	
	public UserServiceException(String message) {
		super(message);
	}
}
