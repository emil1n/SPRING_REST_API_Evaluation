package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.model.Bank;
import com.nissan.repository.IAdminRepository;
@Service
public class AdminServiceImple implements IAdminService{
	
	private IAdminRepository adminRepo;

	@Autowired
	private Validation validation;
	
	@Override
	public Bank saveCustomer(Bank bank) {
		
		System.out.println(bank);
		if(validation.isNameValid(bank.getCustomerName()) && validation.isMobileNumberValid(toString())) {
			return adminRepo.save(bank);
		}
		return null;
	}

	@Override
	public Bank updateCustomer(int AccountNo, long MobileNumber, String EmailId) {
		return  (adminRepo.updateCustomer(AccountNo,MobileNumber,EmailId));
	}

	@Override
	public void deleteCustomer(int AccountNo) {
		adminRepo.deleteById(AccountNo);
		
	}

	@Override
	public List<Bank> getBank() {
		return (List<Bank>) adminRepo.findAll();
	}

	@Override
	public List<Bank> getCustomerByAccNo(int AccountNo) {
		return adminRepo.getCustomerByAccNo(AccountNo);
	}

}
