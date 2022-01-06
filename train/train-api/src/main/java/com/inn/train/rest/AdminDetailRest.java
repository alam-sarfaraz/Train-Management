package com.inn.train.rest;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inn.train.model.AdminDetail;

@RequestMapping("/signup")
public interface AdminDetailRest {

	@PostMapping("/addAdmin")
	AdminDetail addAdmin(@Valid @RequestBody AdminDetail adminDetail) throws Exception;

}
