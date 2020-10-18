package com.workshop2;

public class InvalidCustomerException extends Exception {
	@Override
	public String getMessage(){
		return "Invalid Customer Type !! Exception";
	}
}
