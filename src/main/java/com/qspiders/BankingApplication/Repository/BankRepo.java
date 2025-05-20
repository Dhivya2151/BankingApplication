package com.qspiders.BankingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer>  {
	
	public List<Bank> findBybankName(String name);

}
