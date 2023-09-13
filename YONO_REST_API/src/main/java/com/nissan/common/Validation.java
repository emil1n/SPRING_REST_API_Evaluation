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
	public Boolean isMobileNumberValid (String mobileNumber) {
		boolean bool = false;
		try {
			Pattern pattern = Pattern.compile("^\\d{10}$");
			bool= pattern.matcher(mobileNumber).matches();
			if(!bool) {
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
