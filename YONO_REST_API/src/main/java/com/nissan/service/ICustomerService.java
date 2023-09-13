package com.nissan.service;

public interface ICustomerService {

	// deposite money
	public void depositmoney(int AccountNo);

	// withdraw money
	public void withdrawmoney(int AccountNo);

	// show balance
	public void showbalance(int AccountNo);

	// transfer money
	public void transfermoney(int AccountNo);

}
