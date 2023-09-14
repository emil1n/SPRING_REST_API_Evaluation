package com.nissan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Bank;

@Repository
public interface IAdminRepository extends CrudRepository<Bank,Integer>{
	
	
		//update
		@Modifying
		@Query("update com.nissan.model.Bank set mobileNumber=?2, emailId=?3 where accountNo=?1")
		public void updateCustomerDetails(int accountNo, long mobileNumber, String emailId);
		
		
		//delete 
		@Modifying
		@Query("update com.nissan.model.Bank set isActive=0 where accountNo=?1")
		public void deleteCustomerDetails(int accountNo);
		
}
