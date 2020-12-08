package com.cg.terminsurancecustomer.exception;
/*
 * Validation
  */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public boolean validateCustomerId(Integer customerId) {
		String regex = "^[0-9]{8}*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		matcher = pattern.matcher(String.valueOf(customerId));
		return matcher.matches();
	}
}
