package com.cg.dao;

import com.cg.beans.Account;
import com.cg.beans.Loan;
import com.cg.beans.Transaction;

public interface IBankDao {
	
	public int deposit(String id3,int cash3);
	public int withdraw(String id4,int cash4);
	public Account AccountDetails(String id5);
	public void create(Transaction account);
	
	public int gLoan(String id7,int cash7);
	public int pLoan(String id8,int cash8);
	public Loan LoanDetails(String id9);
	
}