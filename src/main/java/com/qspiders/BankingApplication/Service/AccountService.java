package com.qspiders.BankingApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.qspiders.BankingApplication.Dao.AccountDao;
import com.qspiders.BankingApplication.Dao.TransactionDao;
import com.qspiders.BankingApplication.Dto.Account;
import com.qspiders.BankingApplication.Dto.Customer;
import com.qspiders.BankingApplication.Dto.Transaction;
import com.qspiders.BankingApplication.Exception.AccountNotFoundException;
import com.qspiders.BankingApplication.Exception.AccountTypeNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;
import com.qspiders.BankingApplication.Exception.TransactionNotFoundException;

@Service
public class AccountService {
	@Autowired
	AccountDao dao;
	@Autowired
	TransactionDao tdao;
	
//	
	public ResponseEntity<Account> saveAccount(Account a)
	{
		return new ResponseEntity<Account>(dao.saveaccount(a),HttpStatus.CREATED);
	}
	
//	
	
	public ResponseEntity<Account> findAccount(int id)
	{
		Account dbaccount = dao.findaccount(id);
		if(dbaccount!=null)
		{
			return new ResponseEntity<Account>(dbaccount,HttpStatus.FOUND);
		}
		else
		{
			throw new CustomerNotFoundException("Account not found for the given id");
			
		}
	}
	
//	
	
	public ResponseEntity<Account> deleteAccount(int id)
	{
		Account dbAccount = dao.deleteaccount(id);
		if(dbAccount!=null)
			
		{
			return new ResponseEntity<Account>(dbAccount,HttpStatus.OK); 
		}
		else {
			throw new CustomerNotFoundException("Account not found for the given id");
			
		}
	}	

//
	
	
	public ResponseEntity<Account>updateAccount(int id,Account a)
	{
		Account dbAccount = dao.updateaccount(id, a);
		if(dbAccount!=null)
		{
			return new ResponseEntity<Account>(dbAccount,HttpStatus.OK); 
		}
		else
		{
			throw new CustomerNotFoundException("Account not found for the given id");
		}
	}
	
//	
	
//	public ResponseEntity<Account> addtransactiontoaccount(int aid,int tid)
//	{
//		Account account = dao.findaccount(aid);
//		Transaction transaction = tdao.findtransaction(tid);
//		if(account!=null)
//		{
//			if(transaction!=null)
//			{
//				account.getTransaction().add(transaction);
//				if(transaction.getTransactionAccount()==0)
//				{
//				double balance=account.getAccountBalance();
//				account.setAccountBalance(balance+transaction.getTransactionAmmount());
//				
//				}
//				else
//				{
//					double balance=account.getAccountBalance();
//					account.setAccountBalance(balance-transaction.getTransactionAmmount());
////					Account updateaccount = dao.updateaccount(aid, account);
//				}
//				Account updateaccount = dao.updateaccount(aid, account);
//				return new ResponseEntity<Account>(updateaccount,HttpStatus.OK);
//			}
//			throw new TransactionNotFoundException("Transaction not found for the given id");
//			
//			
//		}
//		throw new AccountNotFoundException("Account not found for the given id");
//		
//		
//	}
	
//	
	
//	public ResponseEntity<Account> removetransactionfromaccount(int aid,int tid)
//	{
//		Account account = dao.findaccount(aid);
//		Transaction transaction = tdao.findtransaction(tid);
//		if(account!=null)
//		{
//			if(transaction!=null)
//			{
//				account.getTransaction().remove(transaction);
//				double balance=account.getAccountBalance();
//				account.setAccountBalance(balance-transaction.getTransactionAmmount());
//				Account updateaccount = dao.updateaccount(aid, account);
//				return new ResponseEntity<Account>(updateaccount,HttpStatus.OK);
//			}
//			throw new TransactionNotFoundException("Transaction not found for the given id");
//			
//			
//		}
//		throw new AccountNotFoundException("Account not found for the given id");
//		
//		
//	}
	
//	
	public ResponseEntity<List<Account>> findbytype(Account.AccountType type )
	{
		List<Account> list = dao.findbytype(type); 
		if(list!=null)
		{
			return new ResponseEntity<List<Account>>(list,HttpStatus.FOUND) ;
		}
		else
		{
			throw new AccountTypeNotFoundException("Account not found for the given type");
		}
		
	}
	
//	
	
	public ResponseEntity<List<Account>> findall()
	{
		return  new ResponseEntity<List<Account>> (dao.findall(),HttpStatus.FOUND);
		
	}
}
