package com.nissan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	//name validation
	public Boolean isNameValid(String name) {
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^A-Za-z ]");
			Matcher nameMatcher = namePattern.matcher(name);
			if(nameMatcher.find()) {
				throw new InvalidNameException("Hey! Invalid Name");
				
			}else if(name.length()>30){
				throw new InvalidNameException("Hey! Invalid Name");
			}else {
				bool = true;
			}
			
		}catch(InvalidNameException e) {
			e.getMessage();
		}
		return bool;
		
		
	}
	
	//mobile number validation
	public Boolean isMobileNumberValid (long mobileNumber) {
		boolean bool = false;
		String number = Long.toString(mobileNumber);
		try {
			Pattern pattern = Pattern.compile("[^0-9]");
			Matcher matcher = pattern.matcher(number);
			if(matcher.find() && number.length() != 10) {
				throw new Exception("Hey! Invalid MobleNumber");
			}
			else {
				bool=true;
			}
		}catch(Exception e) {
			e.getMessage();
		}
		return bool;
	}
	
	
	

}
