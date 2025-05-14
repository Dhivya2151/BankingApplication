package com.qspiders.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>  {

}
