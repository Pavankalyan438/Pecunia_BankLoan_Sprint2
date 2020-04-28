package com.capgemini.pecunia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanDisbursalService;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class LoanDisbursalClass {
	@Autowired
	RestTemplate rest;

	@Autowired
	LoanDisbursalService service;

	@GetMapping("/approvedrequests")
	public List<LoanDisbursal> getApproveLoans() {
		return service.getApproveLoans();
	}

	@GetMapping("/rejectedrequests")
	public List<LoanDisbursal> getRejectedLoans() {
		return service.getRejectedLoans();
	}

}
