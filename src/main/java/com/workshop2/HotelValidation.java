package com.workshop2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelValidation {
	private final String HOTEL_NAME = "^[A-Z]{1}[a-z A-Z]{2,}$";
	public boolean validate(String field) {
		boolean matched = false;
		Pattern pattern = Pattern.compile(HOTEL_NAME);
		Matcher matcher = pattern.matcher(field);
		matched = matcher.find();
		return matched;
	}
}
