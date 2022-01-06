package com.inn.train.rest.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inn.train.model.AdminDetail;
import com.inn.train.rest.AdminDetailRest;
import com.inn.train.service.AdminDetailService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class AdminDetailRestImpl implements AdminDetailRest{

	@Autowired
	AdminDetailService adminDetailService;

	@Override
	public AdminDetail addAdmin(@Valid AdminDetail adminDetail) throws Exception {
		try {
			log.info("Inside the AdminDetailRestImpl of addAdmin :{}",adminDetail);
			return adminDetailService.addAdmin(adminDetail);
		}catch(Exception e) {
			throw e;
		}
	}

}
