package com.nissan.service;

import java.util.List;

import com.nissan.model.Bank;

public interface IAdminService {

	// add a new customer
	public Bank saveCustomer(Bank bank);

	// update  customer by account No
	public Bank updateCustomer(int AccountNo,long MobileNumber,String EmailId);

	// delete customer
	public void deleteCustomer(int AccountNo);

	// list all customers
	public List<Bank> getBank();

	// search by account No
	public List<Bank> getCustomerByAccNo(int AccountNo);

}
