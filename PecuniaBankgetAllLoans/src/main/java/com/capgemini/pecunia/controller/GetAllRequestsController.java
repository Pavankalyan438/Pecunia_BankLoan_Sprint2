package com.capgemini.pecunia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.GetAllRequestsService;

@RestController
@RequestMapping("/loan")
// cross origin is a security concept that puts restrictions to the web
// applications, it prevents JS to produce or consume requests
@CrossOrigin("http://localhost:4200")
public class GetAllRequestsController {
	@Autowired
	GetAllRequestsService service;

	// method used to display all the loan requests that employee have added into
	// requests data base, it gives list as the return type
	@GetMapping("/getAllRequests")
	public ResponseEntity<List<LoanRequests>> getAllRequests() {
		ArrayList<LoanRequests> requests = service.getAllRequests();
		return new ResponseEntity<List<LoanRequests>>(requests, HttpStatus.OK);
	}

}
