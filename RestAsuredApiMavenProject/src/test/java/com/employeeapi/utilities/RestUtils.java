package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	public static String empName() {
		String generatedstring = RandomStringUtils.randomAlphabetic(1);
		return("john"+generatedstring);
		
		
	}
	public static String empSal() {
		String generatedstring = RandomStringUtils.randomNumeric(5);
		return(generatedstring);
		
	}
	public static String empAge() {
		String generatedstring = RandomStringUtils.randomNumeric(2);
		return(generatedstring);
	}

}
