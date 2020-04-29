package com.capgemini.pecunia.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.GetAllRequestsService;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class GetAllRequestsController {
	@Autowired
	GetAllRequestsService service;
	
	@GetMapping("/getAllRequests")
	public ArrayList<LoanRequests> getAllRequests(){
		return service.getAllRequests();
	}
}
