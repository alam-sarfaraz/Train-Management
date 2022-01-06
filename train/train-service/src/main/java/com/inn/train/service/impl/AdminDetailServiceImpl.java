package com.inn.train.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.train.constants.RegexPattern;
import com.inn.train.dao.AdminDetailDao;
import com.inn.train.exceptions.CustomException;
import com.inn.train.model.AdminDetail;
import com.inn.train.service.AdminDetailService;
import com.inn.train.validation.Validation;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminDetailServiceImpl implements AdminDetailService{

	@Autowired
	AdminDetailDao adminDetailDao;

	@Override
	public AdminDetail addAdmin(@Valid AdminDetail adminDetail) throws Exception {
		try {
			log.info("Inside the AdminDetailServiceImpl of addAdmin :{}",adminDetail);
			if(!(adminDetail.getRole().equalsIgnoreCase("ADMIN") || adminDetail.getRole().equalsIgnoreCase("USER"))) {
			   throw new CustomException("Invalid role enter ADMIN or USER");
			}
			Validation.passwordValid(adminDetail);
			RegexPattern.mobileNumberValidation(adminDetail.getMobileNumber());
			adminDetail.setRole("ROLE_"+adminDetail.getRole().toUpperCase());
			return adminDetailDao.save(adminDetail);
		}catch(Exception e) {
			throw e;
		}
	}

}
