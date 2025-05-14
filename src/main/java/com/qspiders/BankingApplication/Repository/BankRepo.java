package com.qspiders.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer>  {

}
