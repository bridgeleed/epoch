package com.bridgeleed.store.service.ex;

public class UsernameAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 896160771039524739L;
	
	public UsernameAlreadyExistException() {
		
	}
	public UsernameAlreadyExistException(String message) {
		super(message);
	}
	

}
