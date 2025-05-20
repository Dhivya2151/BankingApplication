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
import com.qspiders.BankingApplication.Dto.Customer;
import com.qspiders.BankingApplication.Dto.Manager;
import com.qspiders.BankingApplication.Exception.BankNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchListNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;
import com.qspiders.BankingApplication.Exception.ManagerNotFoundException;
import com.qspiders.BankingApplication.Service.BranchService;

@RestController
@RequestMapping("Branch")
public class BranchController {
	@Autowired
	BranchService service;
	
	@PostMapping
	public  ResponseEntity<Branch> savebranch( @RequestBody Branch b)
	{
		return  service.savebranch(b);
	}
	
//	
	@GetMapping	
	public  ResponseEntity<Branch> findbranch(@RequestParam  int id)
	{
		 return service.findbranch(id);
	}
	
//	
	@PutMapping
		public ResponseEntity<Branch> updatebranch(@RequestParam  int id,@RequestBody Branch b)
		{
		return service.updatebranch(id, b);
		}
	
	
	
//	
	@DeleteMapping
	 public ResponseEntity<Branch>deletebranch(@RequestParam int id)
	 {
		 return service.deletebranch(id);
	 }
	 
//	 
	@GetMapping("getall")
	 public ResponseEntity<List<Branch>> findall()
	 {
		return service.findall();
	 }
	
//	 
	 @PutMapping("addbank")
	 
	 public ResponseEntity<Branch> addbanktobranch(@RequestParam int bankid,@RequestParam int branchid)
	 {
		
		 return service.addbanktobranch(bankid, branchid);
	 }
	 
//	 
	 
	 @PutMapping("removebank")
	 public ResponseEntity<Branch> removebankfrombranch(@RequestParam int bankid,@RequestParam int branchid)
	 {
		
		 return service.removebankfrombranch(bankid, branchid);
	 }
	 
//	 
	 @PutMapping("addcustomer")
	 public ResponseEntity addcustomertobranch(@RequestParam int bid, @RequestParam int cid)
	 {
		 return service.addcustomertobranch(bid, cid);
	 }
	 
//	 
	 @PutMapping("removecustomer")
	 public ResponseEntity removecustomerfrombranch(@RequestParam int bid, @RequestParam int cid)
	 {
		return service.removecustomerfrombranch(bid, cid);
	 }
	 
//	 
	 
	 @PutMapping("addmanager")
	 public ResponseEntity<Branch> addmanagertobranch(@RequestParam int branchid,@RequestParam int managerid)
	 {
		 return service.addmanagertobranch(branchid, managerid);
		 
	 }
//	 
	 
	 @PutMapping("removemanager")
	 
	 public ResponseEntity<Branch> removemanagerfrombranch(@RequestParam int branchid,@RequestParam int managerid)
	 {
		 return service.removemanagertobranch(branchid, managerid);
		 
	 }
	 
	
}
