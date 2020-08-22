package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 

public class Account {
	@Id
	private String accountId;
	private String accountName;
	private String address;
	private int depositAmount;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountId, String accountName, String address, int depositAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.address = address;
		this.depositAmount = depositAmount;
	}

	
	
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String string) {
		this.address = string;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", address=" + address
				+ ", depositAmount=" + depositAmount + "]";
	}
	
	
	public String getDetails() {
		return getAccountName()+" "+getAccountId()+" "+getAddress()+" "+getDepositAmount();
	}
	
	public void shpowDetails() {
		System.out.println("Account Name="+getAccountName());
		System.out.println("Account Id="+getAccountId());
		System.out.println("Address="+getAddress());
		System.out.println("Deposit Amount="+getDepositAmount());
	}
	

}
