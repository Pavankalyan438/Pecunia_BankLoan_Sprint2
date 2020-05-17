package com.capgemini.pecunia.service;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.AccountDao;
import com.capgemini.pecunia.dao.LoanDisbursalDao;
import com.capgemini.pecunia.dao.TransactionsDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.entity.Transactions;

@Service
public class LoanDisbursalServiceImp implements LoanDisbursalService {
	@Autowired
	LoanDisbursalDao dao;
	@Autowired
	private AccountDao account;
	@Autowired
	private TransactionsDao transac;

	LoanDisbursal disburse = new LoanDisbursal();
	AccountDetails accountDetails = new AccountDetails();
	Transactions transaction = new Transactions();
	Random rand = new Random();
	long millis = System.currentTimeMillis();
	Date date = new Date(millis);

	// method used to check the credit score and add that into the table by changing
	// the loan status, calculating emi
	@Override
	public List<LoanDisbursal> getApproveLoans(ResponseEntity<LoanRequests[]> approves) {

		LoanRequests[] body = approves.getBody();
		for (int p = 0; p < body.length; p++) {
			LoanRequests l = body[p];
			if ((l.getCreditScore() >= 670) && (!(dao.existsById(l.getLoanId())))) {

				disburse.setAccountId(l.getAccountId());
				disburse.setCreditScore(l.getCreditScore());

				disburse.setLoanId(l.getLoanId());
				disburse.setLoanRoi(l.getLoanRoi());
				disburse.setLoanStatus("Accepted");
				disburse.setLoanTenure(l.getLoanTenure());
				disburse.setLoanType(l.getLoanType());
				double interest = ((l.getLoanAmount() * l.getLoanTenure() * l.getLoanRoi()) / (100 * 12));

				double emi = ((l.getLoanAmount() + interest) / l.getLoanTenure());

				disburse.setEmi(emi);
				disburse.setLoanAmount(l.getLoanAmount() + interest);
				AccountDetails details = account.selectById(l.getAccountId());
				details.setAmount(details.getAmount() + l.getLoanAmount());

				transaction.setAccountId(l.getAccountId());
				transaction.setTransAmount(l.getLoanAmount());
				transaction.setTransDate(date);
				transaction.setTransFrom("BANK");
				transaction.setTransId(rand.nextInt(1000));
				transaction.setTransTo(l.getAccountId());
				transaction.setTransType(l.getLoanType());
				transac.save(transaction);

				dao.save(disburse);
				account.save(details);

			}
		}

		return dao.findAllAccepted();

	}
}
