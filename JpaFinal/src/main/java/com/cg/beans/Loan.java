package com.cg.beans;

import javax.persistence.Entity;

@Entity
public class Loan extends Account{
	private String loanId;
	private int loanAmount;
	private String loanType;
	
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public void showLoanDetails() {
		System.out.println("Loan Id : "+getLoanId());
		System.out.println("Loan amount : "+getLoanAmount());
		System.out.println("Loan Type : "+getLoanType());
	}

}
