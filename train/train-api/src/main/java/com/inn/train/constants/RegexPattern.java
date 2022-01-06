package com.inn.train.constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.inn.train.exceptions.CustomException;

public class RegexPattern {

	public static void trainNumberValidation(String trainNumber) throws CustomException {
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(trainNumber);
		if (matcher.find())
			throw new CustomException("Invalid train Number only enter digits");
	}

	public static void mobileNumberValidation(String mobileNo) throws CustomException {
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(mobileNo);
		if (matcher.find())
			throw new CustomException("Invalid mobile Number only enter digits");
	}

}
