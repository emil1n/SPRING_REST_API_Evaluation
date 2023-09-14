package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="bank")
public class Bank {
	
	@Id
	private Integer accountNo;
	
	private String customerName;
	private String accountType;
	private double balance;
	private long mobileNumber;
	private String emailId;
	private Integer atmPin;
	//check the status 
	private boolean isActive=true;
	
	
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(Integer accountNo, Integer atmPin) {
		super();
		this.accountNo = (int) (Math.random() * 900000000 + 100000000);
		this.atmPin = (int) (Math.random() * 9000 + 1000);
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = (int) (Math.random() * 900000000 + 100000000);
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(Integer atmPin) {
		this.atmPin = (int) (Math.random() * 9000 + 1000);
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", customerName=" + customerName + ", accountType=" + accountType
				+ ", balance=" + balance + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", atmPin="
				+ atmPin + ", isActive=" + isActive + "]";
	}
	
	
	
}
