package com.example.ordermanagementsystem.exceptions;

public class CustomerNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super("Customer does not exists");
	}
}
