package com.cg.service;

import com.cg.beans.Account;
import com.cg.beans.Loan;
import com.cg.beans.Transaction;
import com.cg.dao.BankDao;
import com.cg.dao.IBankDao;

public class BankService implements IBankService {
	
IBankDao bankDao=new BankDao();
	
	
	public BankService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean accountId(String id1) {
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id1.matches(regexId);
	}

	public boolean accountName(String name1) {
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name1.matches(regexName);
	}

	public int deposit(String id3, int cash3) {
		// TODO Auto-generated method stub
		return bankDao.deposit(id3, cash3);
	}

	public int withdraw(String id4, int cash4) {
		// TODO Auto-generated method stub
		return bankDao.withdraw(id4, cash4);
	}

	public Account AccountDetails(String id5) {
		return bankDao.AccountDetails(id5);
		
	}

	public void create(Transaction account) {
		bankDao.create(account);
		
	}
	
	public int gLoan(String id7,int cash7) {
		return bankDao.gLoan(id7, cash7);
	}

	public Loan LoanDetails(String id9) {
		return bankDao.LoanDetails(id9);
		
	}

	public int pLoan(String id8, int cash8) {
		return bankDao.pLoan(id8, cash8);
	}

	
	


}
