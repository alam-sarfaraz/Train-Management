package com.inn.train.validation;

import com.inn.train.exceptions.CustomException;
import com.inn.train.model.AdminDetail;
import com.inn.train.model.TrainDetail;

public class Validation {

	public static void passwordValid(AdminDetail adminDetail) throws CustomException {
		if (!adminDetail.getPassword().equals(adminDetail.getConfirmPassword())) {
			throw new CustomException("Password and confirm password are Not equal");
		}

	}

	public static void statusValidation(TrainDetail trainDetail) throws CustomException {
		if (trainDetail.getStatus().isEmpty()) {
			throw new CustomException("Status is mandatory");
		}
		if (!(trainDetail.getStatus().equalsIgnoreCase("RUNNING")
				|| trainDetail.getStatus().equalsIgnoreCase("CANCELLED"))) {
			throw new CustomException("Status only RUNNING OR CANCELLED");
		}
	}

}
