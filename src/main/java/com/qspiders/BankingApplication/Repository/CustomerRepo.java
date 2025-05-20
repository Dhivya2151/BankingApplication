package com.qspiders.BankingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findBycustomerName(String name);

}
