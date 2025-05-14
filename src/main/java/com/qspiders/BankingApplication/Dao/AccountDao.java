package com.qspiders.BankingApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspiders.BankingApplication.Dto.Account;
import com.qspiders.BankingApplication.Repository.AccountRepo;

@Repository
public class AccountDao {
@Autowired
	AccountRepo repo;

//1.save
public Account saveaccount(Account a)
{
	return repo.save(a);
}

//2.find account
public Account findaccount(int id)
{
	Optional<Account> op = repo.findById(id);
	if(op.isPresent())
	{
		return op.get();
	}
	else
	{
		return null;
	}
}

//3.update 

public Account updateaccount(int id, Account a)
{
	Account account = findaccount(id);
	if(account!=null)
	{
		if(a.getType()!=null)
		{
			account.setType(a.getType());
		}
		return repo.save(account);
				
	}
	else
	{
		return null;
	}	
	
}

//4.delete

public Account deleteaccount(int id)
{
	Account account = findaccount(id);
	
	if(account!=null)
	{
		repo.delete(account);
		return account;
	}
	else
	{
		return null;
	}	
}

//5.findall

public List<Account> findall()
{
	return repo.findAll();
}

}
