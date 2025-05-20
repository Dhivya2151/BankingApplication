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

import com.qspiders.BankingApplication.Dto.Bank;
import com.qspiders.BankingApplication.Dto.Branch;
import com.qspiders.BankingApplication.Exception.BankListNotFoundException;
import com.qspiders.BankingApplication.Exception.BankNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchNotFoundException;
import com.qspiders.BankingApplication.Service.BankService;

@RestController
@RequestMapping("bank")
public class BankController {
	@Autowired
	BankService service;
	
	@PostMapping	
	public ResponseEntity<Bank> savebank( @RequestBody Bank b)
	{
		return  service.savebank(b);
	}
	
//	
	@GetMapping	
	public  ResponseEntity<Bank>  findbank(@RequestParam int id)
	{
		return service.findbank(id);
	}
	
//	
	@DeleteMapping
	public ResponseEntity<Bank> deletebank(@RequestParam int id)
	{
		return service.deletebank(id);
	}
	
//	
	@PutMapping
	public ResponseEntity<Bank> updatebank(@RequestParam int id,@RequestBody Bank b )
	{
		return service.updatebank(id, b);
		
	}
	
//	
	@GetMapping("getall")	
	public ResponseEntity<List<Bank>>  findall()
	{
		return service.findall();
	} 
	
//	add branch to bank
	
	@PutMapping("addbranch")
	
	public  ResponseEntity<Bank> addbranchtobank(@RequestParam int bankid,@RequestParam int branchid)
	{
		return service.addbranchtobank(bankid, branchid);
		
		
	}
	
	
//	remove branch from bank
	@PutMapping("removebranch")
	public  Bank removebranchfrombank(@RequestParam int bankid,@RequestParam int branchid)
	{
		 return service.removebranchfrombank(bankid, branchid);
		
	}
	
	
//	
	@GetMapping("byname")
	public ResponseEntity<List<Bank>> findbyname(@RequestParam String name)
	{
		return service.findbyname(name);
	}
	
	

}
