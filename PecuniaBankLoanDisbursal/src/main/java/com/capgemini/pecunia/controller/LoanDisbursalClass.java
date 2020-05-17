package com.capgemini.pecunia.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanDisbursalService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class LoanDisbursalClass {
	@Autowired
	RestTemplate rest;

	@Autowired
	LoanDisbursalService service;

	// this method uses restTemplate to take the input from the another microservice
	// and passes them to the service layer
	@GetMapping("/approvedrequests")
	@HystrixCommand(fallbackMethod = "allApprovedsFallback")
	public ArrayList<LoanDisbursal> allApproved() {
		ResponseEntity<LoanRequests[]> approves = rest.getForEntity("http://localhost:1005/loan/getAllRequests",
				LoanRequests[].class);

		return (ArrayList<LoanDisbursal>) service.getApproveLoans(approves);

	}

	// fallback method for the allApproved method, when ever the main microservice
	// used with restTemplate is down in order to stop the inflow of requsts we use
	// fallback method
	@SuppressWarnings("unused")
	private ArrayList<LoanDisbursal> allApprovedsFallback() {
		LoanDisbursal loandis = new LoanDisbursal("SERVER DOWN", 0, 0, 0, 0, "SERVER DOWN", "SERVER DOWN", 0, 0);
		ArrayList<LoanDisbursal> al = new ArrayList<>();

		al.add(loandis);
		return al;

	}
}
