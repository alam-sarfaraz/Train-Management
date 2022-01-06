package com.inn.train.service;

import javax.validation.Valid;

import com.inn.train.model.AdminDetail;

public interface AdminDetailService {

	public AdminDetail addAdmin(@Valid AdminDetail adminDetail) throws Exception;

}
