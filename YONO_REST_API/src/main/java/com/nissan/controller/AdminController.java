package com.nissan.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Bank;
import com.nissan.service.AdminServiceImple;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtil;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	//private JwtUtil jwtUtil;

	// list all customer
	@GetMapping("/bank")
	public List<Bank> getCustomer(){
		
		
		
		//@RequestHeader(value = "authorization", defaultValue = "") String auth)
			//throws AccessDeniedException {
		//jwtUtil.verify(auth);
		return adminService.getCustomerDetails();
	}

	// add new customer
	@PostMapping("/bank")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Bank bank) {
		System.out.println(bank);
		bank.setAccountNo(1);
		bank.setAtmPin(2);
		System.out.println(bank);
		if (adminService.saveCustomerDetails(bank) == null) {
			apiResponse.setData("INVALID DETAILS !!!!!!");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID !!!");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		apiResponse.setData("CUSTOMER ADDED SUCCESSFULLY");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// update Customer
	@PutMapping("/bank/update/{accountNo}&{mobileNumber}&{emailId}")
	public ResponseEntity<APIResponse> updateCustomer(@PathVariable Integer accountNo, @PathVariable long mobileNumber,
			@PathVariable String emailId) {
		adminService.updateCustomerDetails(accountNo, mobileNumber, emailId);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// delete Customer
	@DeleteMapping("/bank/{accountNo}")
	public ResponseEntity<APIResponse> deleteCustomerDetails(@PathVariable Integer accountNo){ 
		adminService.deleteCustomerDetails(accountNo);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// search by account No
	@GetMapping("/bank/search/{accountNo}")
	public Bank getCustomerByAccNo(@PathVariable int accountNo) {
		//jwtUtil.verify(auth);
		return adminService.getCustomerByAccNo(accountNo);
	}

}
