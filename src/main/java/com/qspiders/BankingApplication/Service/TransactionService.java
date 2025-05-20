package com.qspiders.BankingApplication.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qspiders.BankingApplication.Dao.AccountDao;
import com.qspiders.BankingApplication.Dao.TransactionDao;
import com.qspiders.BankingApplication.Dto.Account;
import com.qspiders.BankingApplication.Dto.Transaction;
import com.qspiders.BankingApplication.Exception.AccountNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;
import com.qspiders.BankingApplication.Exception.TransactionAccountTypeNotFoundException;
import com.qspiders.BankingApplication.Exception.TransactionNotFoundException;
import com.qspiders.BankingApplication.Exception.TransactionTypeNotFoundException;

@Service
public class TransactionService {
	@Autowired
	TransactionDao dao;
	@Autowired
	AccountDao adao;
	
//	
	
	public ResponseEntity<Transaction> saveTransaction(Transaction t , int  accid)
	{
		Account account = adao.findaccount(accid);
		if(account!=null)
		{
			if(t!=null)
			{

				if(t.getTransactionAccount()==0)
				{

					double balance= account.getAccountBalance();
					account.setAccountBalance(balance+t.getTransactionAmmount());
					adao.updateaccount(accid, account);
					
					
				}
				else
				{
					double balance= account.getAccountBalance();
					if(balance>=t.getTransactionAmmount())
					{
					account.setAccountBalance(balance-t.getTransactionAmmount());
					adao.updateaccount(accid, account);
					}
				}
				
				account.getTransaction().add(t);
				t.setAccount(account);
				return new ResponseEntity<Transaction>(dao.savetransaction(t),HttpStatus.CREATED);
			}
			throw new TransactionNotFoundException("Transaction not found for the given id");
			
		}
		throw new AccountNotFoundException("Account not found for the given id");
	}
	
//	
	public ResponseEntity<List<Transaction>> findTransaction(int aid)
	{
		Account account = adao.findaccount(aid);
		if(account!=null)
		{
			return new ResponseEntity<List<Transaction>>(account.getTransaction(),HttpStatus.FOUND);
		}
		else
		{
			throw new TransactionNotFoundException("Transaction not found for the given id");
			
		}
	}
	
	
//	
	
	public ResponseEntity<List<Transaction>> findall()
	{
		return new ResponseEntity<List<Transaction>>(dao.findall(),HttpStatus.FOUND);
	}

	
//	
	
	
	

	
	public ResponseEntity<List<Transaction>> findbytype(Transaction.TransactionType type, int accid)
	{
		List<Transaction>list=new ArrayList();
	Account account = adao.findaccount(accid);
	for(Transaction t:account.getTransaction())
	{
	if(t.getType()==type)
	{
		list.add(t);
	}
	
	}	
	
	if(list!=null)
	{
		return new ResponseEntity<List<Transaction>>(list,HttpStatus.FOUND);
	}
	else
	{
		throw new TransactionTypeNotFoundException("Transaction not found for the given type");
	}
	
	
	
	
	}
	
//	public ResponseEntity<List<Transaction>> findBytransactionAccount(int acctype)
//	{
//		List<Transaction> findBytransactionAccount = dao.findBytransactionAccount(acctype);
//
//	
//	if(findBytransactionAccount!=null)
//	{
//		return new ResponseEntity<List<Transaction>>(findBytransactionAccount,HttpStatus.FOUND);
//	}
//	else
//	{
//		throw new TransactionAccountTypeNotFoundException("Transaction not found for the given type");
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	}
}

