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
import com.nissan.util.JwtUtil;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminServiceImple adminService;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private JwtUtil jwtUtil;

	// list all customer
	@GetMapping("/bank")
	public List<Bank> getBank(@RequestHeader(value = "authorization", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtil.verify(auth);

		return adminService.getBank();
	}

	// add new customer
	@PostMapping("/bank")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Bank bank) {
		System.out.println(bank);
		if (adminService.saveCustomer(bank) == null) {
			apiResponse.setData("Name can have only alphabets!");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID NAME");

			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		apiResponse.setData("CUSTOMER ADDED SUCCESSFULLY");
		apiResponse.setStatus(200);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// update Customer
	@PutMapping("/bank")
	public void updateCustomer(@PathVariable Integer AccountNo, @PathVariable long MobileNumber,
			@PathVariable String EmailId) {
		adminService.updateCustomer(AccountNo, MobileNumber, EmailId);

	}

	// delete Customer
	@DeleteMapping("/employee/{AccountNo}")
	public void deleteCustomer(@PathVariable Integer AccountNo) {
		adminService.deleteCustomer(AccountNo);

	}

	// search by account No
	@GetMapping("/employees/search/{AccountNo}")
	public List<Bank> getCustomerByAccNo(@PathVariable Integer AccountNo,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtil.verify(auth);
		return adminService.getCustomerByAccNo(AccountNo);
	}

}
