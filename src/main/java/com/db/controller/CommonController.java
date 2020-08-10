package com.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.domain.ResponseObject;
import com.db.service.ICommonService;

@RestController
@RequestMapping("/api/v1")
public class CommonController {

	@Autowired
	ICommonService commonService;
	
	@GetMapping("/welcomeMessage")
	public String welcomeMessage() {
		return "hi";
	}
	
	@GetMapping("/allStudents")
	public ResponseObject allStudentDetails() {
		return commonService.getAllStudentsDetails(); 
	}
	
	@GetMapping("/allProducts")
	public ResponseObject allProductDetails() {
		return commonService.getAllProductDetails();
	}
	
}
