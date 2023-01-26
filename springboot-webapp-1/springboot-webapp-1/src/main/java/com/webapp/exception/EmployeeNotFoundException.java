package com.webapp.exception;


public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5805440851335020164L;

	public EmployeeNotFoundException() {
		super();
	}
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
