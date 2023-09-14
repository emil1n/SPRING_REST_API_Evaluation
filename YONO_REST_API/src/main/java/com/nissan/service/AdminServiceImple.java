package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.common.Validation;
import com.nissan.model.Bank;
import com.nissan.repository.IAdminRepository;

@Transactional
@Service
public class AdminServiceImple implements IAdminService{
	
	@Autowired
	private IAdminRepository adminRepo;

	@Autowired
	private Validation validation;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Override
	public List<Bank> getCustomerDetails() {
		
		return (List<Bank>) adminRepo.findAll();
	}
	
	@Override
	public Bank saveCustomerDetails(Bank bank) {
		if(validation.isNameValid(bank.getCustomerName()) && validation.isMobileNumberValid(bank.getMobileNumber())) {
		
		return adminRepo.save(bank);
	}
		return null;}
		
		@Override
		public Bank getCustomerByAccNo(int accountNo) {
			return adminRepo.findById(accountNo).orElseThrow(()->new RuntimeException("Customer not found for id "+accountNo));
		}

	@Override
	public APIResponse deleteCustomerDetails(int accountNo) {
		adminRepo.deleteCustomerDetails(accountNo);
		apiResponse.setData("customer deleted successfully");
		apiResponse.setStatus(200);
		return apiResponse;
	}

	@Override
	public APIResponse updateCustomerDetails(int accountNo, long mobileNumber, String emailId) {
		adminRepo.updateCustomerDetails(accountNo,mobileNumber,emailId);
		apiResponse.setData("customer updated successfully");
		apiResponse.setStatus(200);
		return apiResponse;
	}


}
