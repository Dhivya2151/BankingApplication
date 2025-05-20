package com.qspiders.BankingApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspiders.BankingApplication.Dto.Account;
import com.qspiders.BankingApplication.Dto.Transaction;
import com.qspiders.BankingApplication.Exception.AccountNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;
import com.qspiders.BankingApplication.Exception.TransactionNotFoundException;
import com.qspiders.BankingApplication.Service.AccountService;

@RestController
@RequestMapping("Account")
public class AccountController {
	@Autowired
	AccountService service;
	
	@PostMapping
	public ResponseEntity<Account> saveAccount(@RequestBody Account a)
	{
		return service.saveAccount(a);
	}
	
//	
	@GetMapping
	public ResponseEntity<Account> findAccount(@RequestParam int id)
	{
		return service.findAccount(id);
	}
	
//	
	@DeleteMapping	
	public ResponseEntity<Account> deleteAccount(@RequestParam int id)
	{
		return service.deleteAccount(id);
	}	

//
	
	@PutMapping
		public ResponseEntity<Account>updateAccount(@RequestParam int id,@RequestBody Account a)
	{
		return service.updateAccount(id, a);
	}
	
//	
	
//	@PutMapping("addtransaction")
//	public ResponseEntity<Account> addtransactiontoaccount(@RequestParam int aid,@RequestParam int tid)
//	{
//		return service.addtransactiontoaccount(aid, tid);
//	}
//	
////	
//	@PutMapping("removetransaction")
//	public ResponseEntity<Account> removetransactionfromaccount(@RequestParam int aid, @RequestParam int tid)
//	{
//		return service.removetransactionfromaccount(aid, tid);
//		
//	}
	
//	
	@GetMapping("bytype")
	public ResponseEntity<List<Account>> findbytype(@RequestParam Account.AccountType type)
	{
		return service.findbytype(type);
	}
	
//	
	@GetMapping("getall")
	public ResponseEntity<List<Account>> findall()
	{
		return service.findall() ;
	}
	

}
