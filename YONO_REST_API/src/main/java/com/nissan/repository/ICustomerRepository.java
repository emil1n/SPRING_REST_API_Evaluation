package com.nissan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Bank;
@Repository
public interface ICustomerRepository extends CrudRepository<Bank, Integer> {

}
