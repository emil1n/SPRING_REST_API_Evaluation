package com.nissan.service;

import com.nissan.common.APIResponse;

public interface ICustomerService {

	// deposite money
	public APIResponse depositmoney(int accountNo,int amount);

	// withdraw money
	public APIResponse withdrawmoney(int accountNo,int amount);

	// show balance
	public APIResponse showbalance(int accountNo);

	// transfer money
	public APIResponse transfermoney(int accountNo1,int accountNo2,int amount);

}
