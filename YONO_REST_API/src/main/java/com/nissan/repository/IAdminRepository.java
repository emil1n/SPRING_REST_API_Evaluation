package com.nissan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Bank;
@Repository
public interface IAdminRepository extends CrudRepository<Bank,Integer>{
	
	//search by Account No
	
		//custom methods using JPQL query
		@Query("from Bank WHERE AccountNo like %?1%")
		public List<Bank> getCustomerByAccNo(Integer AccountNo);

		
		@Modifying
		@Query("update com.nissan.model.Bank set MobileNumber=?2, EmialId=?3 where AccountNo=?1")
		public Bank updateCustomer(int accountNo, long mobileNumber, String emailId);
		
		@Modifying
		@Query("update com.nissan.model.Bank set isActive=0 where AccountNo=?1")
		public Bank deleteCustomer(int accountNo);
		
}
