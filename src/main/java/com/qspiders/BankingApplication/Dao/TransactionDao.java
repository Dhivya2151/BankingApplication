package com.qspiders.BankingApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspiders.BankingApplication.Dto.Transaction;
import com.qspiders.BankingApplication.Repository.TransactionRepo;

@Repository
public class TransactionDao {
	@Autowired	
	TransactionRepo repo; 
	
//	1.save
	
	public Transaction savetransaction(Transaction t)
	{
		return repo.save(t);
	}
	
//	2.find transaction
	
	public Transaction findtransaction(int id)
	{
		Optional<Transaction> op = repo.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			return null;
		}
	}
	
//	3.update
	
	public Transaction updateaccount(int id, Transaction t)
	{
		Transaction transaction = findtransaction(id); 
		if(transaction!=null)
		{
			if(t.getType()!=null)
			{
				transaction.setType(t.getType());
			}
			if(t.getAccount()!=null)
			{
				transaction.setTransactionAccount(t.getTransactionAccount());
				
			}
			if(t.getTransactionAmmount()!=0.0d)
			{
				transaction.setTransactionAmmount(t.getTransactionAmmount());
			}
				
			return repo.save(transaction);
		}
		else
		{
			return null;
		}
	}
	
//	4.delete 
	public Transaction deletetransaction(int id)
	{
		  Transaction t=   findtransaction(id);
		  if(t!=null)
		  {
			  repo.delete(t);
			  return t;
		  }
		  else
		  {
			  return null;
		  }
	}
	
//	5.findall
	public List<Transaction> findall()
	{
		return repo.findAll();
	}
	
	
	
	
	

}
