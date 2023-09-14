package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.ICustomerService;



@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private APIResponse apiResponse;
	
	@PutMapping("/bank/deposit/{accountNo}&{amount}")
	public ResponseEntity<APIResponse> depositmoney(@PathVariable int accountNo,@PathVariable int amount){
		apiResponse =customerService.depositmoney(accountNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	@PutMapping("/users/withdraw/{accountNo}&{amount}")
	public ResponseEntity<APIResponse> withdrawmoney(@PathVariable int accountNo,@PathVariable int amount){
	  apiResponse =	customerService.withdrawmoney(accountNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	@GetMapping("/users/showbalance/{accNum}")
	public ResponseEntity<APIResponse> showbalance(@PathVariable int accountNo){
		apiResponse =customerService.showbalance(accountNo);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	@PutMapping("/users/transfer/{accountNo1}&{accountNo2}&{amount}")
	public ResponseEntity<APIResponse> transfermoney(@PathVariable int accountNo1,@PathVariable int accountNo2,@PathVariable int amount){
	  apiResponse =	customerService.transfermoney(accountNo1,accountNo2, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}

	
	
	

}
