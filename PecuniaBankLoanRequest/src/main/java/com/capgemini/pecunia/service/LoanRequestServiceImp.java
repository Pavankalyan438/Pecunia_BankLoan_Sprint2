package com.capgemini.pecunia.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.LoanRequestDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.exception.BankAccountNotFound;

@Service
public class LoanRequestServiceImp implements LoanRequestService {
	@Autowired
	LoanRequestDao dao;

	@Override
	public String loanRequest(LoanRequests loanreq) {
		String s1 = loanreq.getAccountId();
		Optional<AccountDetails> details = dao.findBank(s1);

		if (details.isPresent()) {
			dao.save(loanreq);

			return "Your Loan Request with " + loanreq.getAccountId() + " accountid is successful";
		} else {
			
			throw new BankAccountNotFound("No BankAccount found with " + loanreq.getAccountId()
					+ "\n You need to have an Bank Account to applay Loan");
		}

	}

	@Override
	public ArrayList<LoanRequests> getAllRequests() {
		// TODO Auto-generated method stub
		return (ArrayList<LoanRequests>) dao.findAll();
	}

	@Override
	public ArrayList<LoanRequests> getAllRejects() {
		// TODO Auto-generated method stub
		return dao.getAllRejects();
	}
}