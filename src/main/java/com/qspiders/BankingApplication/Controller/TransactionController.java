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
import com.qspiders.BankingApplication.Exception.TransactionNotFoundException;
import com.qspiders.BankingApplication.Service.TransactionService;

@RestController
@RequestMapping("Transaction")
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@PostMapping
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction t, @RequestParam int accid)
	{

		return service.saveTransaction(t,accid);
	}
	
//	
	@GetMapping 
	public ResponseEntity<List<Transaction>> findTransaction(@RequestParam  int id)
	{
		return service.findTransaction(id);
	}
	
	

//	
	
//	
	@GetMapping("getall")
	public ResponseEntity<List<Transaction>> findall()
	{
		return service.findall();
	}
	
//
	@GetMapping("bytype")
	public ResponseEntity<List<Transaction>> findbytype(@RequestParam Transaction.TransactionType type,@RequestParam int accid)
	{
		return service.findbytype(type,accid);
}
	
//	@GetMapping("bytransactiontype")
//	public ResponseEntity<List<Transaction>> findbytansactionaccounttype(@RequestParam int type)
//	{
//		return service.findBytransactionAccount(type);
//} 
	
}
