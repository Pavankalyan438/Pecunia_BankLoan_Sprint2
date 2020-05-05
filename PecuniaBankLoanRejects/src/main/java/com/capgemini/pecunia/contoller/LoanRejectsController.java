package com.capgemini.pecunia.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanRejectsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class LoanRejectsController {
	String str = null;
	@Autowired
	RestTemplate rest;
	@Autowired
	LoanRejectsService service;
	LoanRequests loanrequ = new LoanRequests();
	LoanDisbursal loandis = new LoanDisbursal();

	@HystrixCommand(fallbackMethod = "allRequFallback")
	@GetMapping("/allreqrejects")
	public List allRejects() {
		ResponseEntity<LoanRequests[]> requests = rest.getForEntity("http://localhost:1005/loan/getAllRequests",
				LoanRequests[].class);

		return service.loanRejects(requests);

	}

	@SuppressWarnings({ "unused", "unchecked" })
	private List allRequFallback() {
		List l=new ArrayList<>();
		loandis.setAccountId("cant fetch");
		loandis.setLoanStatus("cannot fetch");
		loandis.setLoanType("cannot fetch");
		
		l.add(loandis);
		return l;
		/*List l=new ArrayList<>();
		l.add("NO server is UP!");
		return (ArrayList) l;
*/
	}

}
