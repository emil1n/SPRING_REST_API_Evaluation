package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nissan.common.APIResponse;
import com.nissan.model.Bank;
import com.nissan.repository.ICustomerRepository;
import com.nissan.util.JwtUtil;


@Transactional
@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private APIResponse apiResponse;
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public APIResponse depositmoney(int accountNo, int amount) {
		List<Bank> bank = (List<Bank>) customerRepository.findAll();
		Bank obj = null;
		for (Bank b : bank) {
			if (b.getAccountNo() == accountNo) {
				obj = b;
			}
		}
		if (amount > 50000) {
			apiResponse.setData("ENTER PAN CARD NUMBER :");
			obj.setBalance(obj.getBalance() + amount);
			apiResponse.setData("Amount deposited successfully:Balance =" + obj.getBalance());
			apiResponse.setStatus(500);
		}

		else {
			obj.setBalance(obj.getBalance() + amount);
			apiResponse.setData("Amount deposited successfully:Balance =" + obj.getBalance());
			apiResponse.setStatus(500);
		}

		return apiResponse;

	}

	@Override
	public APIResponse withdrawmoney(int accountNo, int amount) {
		List<Bank> bank = (List<Bank>) customerRepository.findAll();
		for (Bank b : bank) {
			if (b.getAccountNo() == accountNo) {
				double availableBalance = b.getBalance() - 1000;
				if (amount > availableBalance) {
					apiResponse.setData("Insufficient funds..!!!");
					apiResponse.setStatus(500);
					apiResponse.setError("no sufficent balance ");
					return apiResponse;

				}
				b.setBalance(b.getBalance() - amount);

				apiResponse.setData("Amount withdrawn successfully : Balance =" + b.getBalance());
				apiResponse.setStatus(200);
				break;
			}
		}
		return apiResponse;
	}

	@Override
	public APIResponse showbalance(int accountNo) {
		List<Bank> bank = (List<Bank>) customerRepository.findAll();
		Bank obj = null;
		for (Bank b : bank) {
			if (b.getAccountNo() == accountNo) {
				obj = b;
			}
		}
		apiResponse.setData("Balance="+obj.getBalance());
		apiResponse.setStatus(200);
		return apiResponse;
	}

	@Override
	public APIResponse transfermoney(int accountNo1, int accountNo2, int amount) {
		List<Bank> bank = (List<Bank>) customerRepository.findAll();
		Bank obj1 = null;
		Bank obj2 = null;
		for (Bank b : bank) {
			if (b.getAccountNo() == accountNo1) {
				obj1 = b;
			}
		}
		for (Bank b : bank) {
			if (b.getAccountNo() == accountNo2) {
				obj2 = b;
			}
		}
		obj2.setBalance(obj2.getBalance()+amount);
		obj1.setBalance(obj1.getBalance()-amount);
		apiResponse.setData("Amount transferred successfully!!!");
		apiResponse.setStatus(200);
		return apiResponse;

	}

}
