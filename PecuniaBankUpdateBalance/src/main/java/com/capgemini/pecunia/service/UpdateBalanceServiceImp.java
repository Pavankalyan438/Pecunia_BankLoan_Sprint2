package com.capgemini.pecunia.service;

import java.sql.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.AccountDao;
import com.capgemini.pecunia.dao.TransactionsDao;
import com.capgemini.pecunia.dao.UpdateBalanceDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.Transactions;

@Service
public class UpdateBalanceServiceImp implements UpdateBalanceService {
	@Autowired
	UpdateBalanceDao dao;
	@Autowired
	private TransactionsDao transac;
	@Autowired
	private AccountDao account;

	private Transactions transaction = new Transactions();
	Random rand = new Random();
	long millis = System.currentTimeMillis();
	Date date = new Date(millis);

	// this method is used to pay the emi, it takes the loan disbursal as the input
	// and checks the tenure condition and then cuts the emi or shows a message if
	// condition fails
	@Override
	public String updateBalance(LoanDisbursal loandis) {

		if ((loandis.getLoanTenure() > 0)) {
			loandis.setLoanId(loandis.getLoanId());
			loandis.setAccountId(loandis.getAccountId());
			loandis.setCreditScore(loandis.getCreditScore());
			loandis.setEmi(loandis.getEmi());

			double amount = loandis.getLoanAmount() - loandis.getEmi();

			loandis.setLoanAmount(amount);
			loandis.setLoanRoi(loandis.getLoanRoi());
			loandis.setLoanStatus(loandis.getLoanStatus());
			loandis.setLoanTenure(loandis.getLoanTenure() - 1);
			loandis.setLoanType(loandis.getLoanType());

			transaction.setAccountId(loandis.getAccountId());
			transaction.setTransAmount(loandis.getEmi());
			transaction.setTransDate(date);
			transaction.setTransFrom(loandis.getAccountId());
			transaction.setTransId(rand.nextInt(1000));
			transaction.setTransTo("Pecunia Bank");
			transaction.setTransType("EMI");
			transac.save(transaction);
			AccountDetails details = account.selectById(loandis.getAccountId());
			details.setAmount(details.getAmount() - loandis.getEmi());
			account.save(details);

			dao.save(loandis);
			return loandis.getLoanType() + " EMI Rs/- " + loandis.getEmi() + " from " + loandis.getAccountId()
					+ " account is paid!! ";

		} else {
			return "Due Loan has been cleared!!";
		}
	}

}
