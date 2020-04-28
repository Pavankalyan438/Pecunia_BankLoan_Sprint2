package com.capgemini.pecunia.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanRejectsService;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class LoanRejectsController {
	@Autowired
	RestTemplate rest;
	@Autowired
	LoanRejectsService service;
	LoanRequests loanrequ=new LoanRequests();
	
	@GetMapping("/allreqrejects")
	public List<LoanDisbursal> allRejects() {
		ResponseEntity<LoanRequests[]> requests=  rest.getForEntity("http://localhost:1000/loan/getAllRejects",
				LoanRequests[].class);
	return service.loanRejects(requests);

	
	
}}
