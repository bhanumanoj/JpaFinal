package com.cg.beans;

import javax.persistence.Entity;

@Entity
public class Transaction extends Loan{
	
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}
