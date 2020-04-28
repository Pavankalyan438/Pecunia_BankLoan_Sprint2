package com.capgemini.pecunia.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loandisbursal")
public class LoanDisbursal {
	private String accountId;
	private double loanAmount;
	private int loanTenure;
	private int creditScore;
	private double loanRoi;
	private String loanStatus;
	private String loanType;
	private double emi;
	@Id
	private int loanId;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public double getLoanRoi() {
		return loanRoi;
	}
	public void setLoanRoi(double loanRoi) {
		this.loanRoi = loanRoi;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	@Override
	public String toString() {
		return "LoanDisbursal [accountId=" + accountId + ", loanAmount=" + loanAmount + ", loanTenure=" + loanTenure
				+ ", creditScore=" + creditScore + ", loanRoi=" + loanRoi + ", loanStatus=" + loanStatus + ", loanType="
				+ loanType + ", emi=" + emi + ", loanId=" + loanId + "]";
	}
	

}
