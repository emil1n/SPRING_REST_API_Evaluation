package com.nissan.model;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	
	
	
	
	
	@Id
	@Column(name="AccountNo")
	private Integer AccountNo;
	
	
	private String customerName;
	
	private String AccountType;

	private double Balance;
	

	private long MobileNumber;
	
	private String EmailId;
	
	private Integer ATMPin;
	
	//check the status 
	private boolean isActive=true;
	
	
	
	
	

	
	

	public Integer getAccountNo() {
		return AccountNo;
	}









	public void setAccountNo(Integer accountNo) {
		AccountNo = accountNo;
	}









	public String getCustomerName() {
		return customerName;
	}









	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}









	public String getAccountType() {
		return AccountType;
	}









	public void setAccountType(String accountType) {
		AccountType = accountType;
	}









	public double getBalance() {
		return Balance;
	}









	public void setBalance(double balance) {
		Balance = balance;
	}









	public long getMobileNumber() {
		return MobileNumber;
	}









	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}









	public String getEmailId() {
		return EmailId;
	}









	public void setEmailId(String emailId) {
		EmailId = emailId;
	}









	public Integer getATMPin() {
		return ATMPin;
	}









	public void setATMPin(Integer aTMPin) {
		ATMPin = aTMPin;
	}









	public boolean isActive() {
		return isActive;
	}









	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}









	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}









	@Override
	public String toString() {
		return "Bank [AccountNo=" + AccountNo + ", customerName=" + customerName + ", AccountType=" + AccountType
				+ ", Balance=" + Balance + ", MobileNumber=" + MobileNumber + ", EmailId=" + EmailId + ", ATMPin="
				+ ATMPin + ", isActive=" + isActive + "]";
	}
	
	

	
	
}
