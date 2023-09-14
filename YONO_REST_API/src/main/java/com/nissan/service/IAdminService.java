package com.nissan.service;

import java.util.List;

import com.nissan.common.APIResponse;
import com.nissan.model.Bank;

public interface IAdminService {
	
	// list all customers
	public List<Bank> getCustomerDetails();

	// add a new customer
	public Bank saveCustomerDetails(Bank bank);

	// update  customer by account No
	public APIResponse updateCustomerDetails(int accountNo,long mobileNumber,String emailId);

	// delete customer
	public APIResponse deleteCustomerDetails(int accountNo);

	// search by account No
	public Bank getCustomerByAccNo(int accountNo);

}
