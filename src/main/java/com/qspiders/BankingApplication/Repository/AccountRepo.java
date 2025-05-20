package com.qspiders.BankingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>  {
	public List<Account> findBytype(Account.AccountType Type );
	

}
