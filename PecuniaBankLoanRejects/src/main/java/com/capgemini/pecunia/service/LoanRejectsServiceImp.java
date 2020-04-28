package com.capgemini.pecunia.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.LoanRejectsDao;
import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;

@Service
public class LoanRejectsServiceImp implements LoanRejectsService {

	@Autowired
	LoanRejectsDao dao;
	LoanDisbursal disburse = new LoanDisbursal();
	

	@Override
	public List<LoanDisbursal> loanRejects(ResponseEntity<LoanRequests[]> requests) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Iterator iter = ((List<LoanRequests>) requests).iterator();
		while (iter.hasNext()) {

			LoanRequests l = (LoanRequests) iter.next();

			disburse.setAccountId(l.getAccountId());
			disburse.setCreditScore(l.getCreditScore());
			disburse.setLoanAmount(0);
			disburse.setLoanId(l.getLoanId());
			disburse.setLoanRoi(l.getLoanRoi());
			disburse.setLoanStatus("rejected");
			disburse.setLoanTenure(l.getLoanTenure());
			disburse.setLoanType(l.getLoanType());
			disburse.setEmi(0);
			dao.save(disburse);
		}
		List<LoanDisbursal> i= dao.findAll();
		 return i;
	}

}