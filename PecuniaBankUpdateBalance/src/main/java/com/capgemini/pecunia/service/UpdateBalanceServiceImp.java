package com.capgemini.pecunia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.UpdateBalanceDao;
import com.capgemini.pecunia.entity.LoanDisbursal;
@Service
public class UpdateBalanceServiceImp implements UpdateBalanceService {
	@Autowired
	UpdateBalanceDao dao;
	@Override
	public String updateBalance(LoanDisbursal loandis) {
		if((loandis.getLoanAmount()-loandis.getEmi())>0) {
			loandis.setLoanId(loandis.getLoanId());
			loandis.setAccountId(loandis.getAccountId());
			loandis.setCreditScore(loandis.getCreditScore());
			loandis.setEmi(loandis.getEmi());
				double amount = loandis.getLoanAmount() - loandis.getEmi();
				amount=Math.round(amount*100)/100;
				loandis.setLoanAmount(amount);
				loandis.setLoanRoi(loandis.getLoanRoi());
				loandis.setLoanStatus(loandis.getLoanStatus());
				loandis.setLoanTenure(loandis.getLoanTenure() - 1);
				loandis.setLoanType(loandis.getLoanType());
				System.out.println(loandis);
				dao.save(loandis);
			
			return "This month Emi amount " + loandis.getEmi() +" of "+loandis.getAccountId()+ " accoount for "+loandis.getLoanType()+" is paid";
			}
			else {
			return "Sufficient Account Balance is not found to pay EMI, deposit money in your account to pay month emi";
		}}

}
