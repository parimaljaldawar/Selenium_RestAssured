package com.selenium.testing.selenium_test_Handson_project;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.*;
import java.util.Scanner;

public class restUtils 
{
	
	public static string getFirstName() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}
	
	
	public static string empsal() 
	{
	
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
		
	}
	
	public static string id() 
	{
	
		String generatedString = RandomStringUtils.randomNumeric(1);
		return (generatedString);
		
	}

}