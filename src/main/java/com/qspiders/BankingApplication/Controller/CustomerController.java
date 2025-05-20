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
import com.qspiders.BankingApplication.Dto.Customer;
import com.qspiders.BankingApplication.Dto.Manager;
import com.qspiders.BankingApplication.Exception.AccountNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;
import com.qspiders.BankingApplication.Service.CustomerService;

@RestController
@RequestMapping("Customer")
public class CustomerController {
	@Autowired
	CustomerService service;

	@PostMapping
	public  ResponseEntity<Customer> saveCustomer( @RequestBody Customer c)
	{
		return  service.savecustomer(c);
	}
	
//	
	@GetMapping	
	public  ResponseEntity<Customer> findCustomer(@RequestParam  int id)
	{
		 return service.findcustomer(id);
	}
	
//	
	@PutMapping
		public ResponseEntity<Customer> updateCustomer(@RequestParam  int id,@RequestBody Customer c)
		{
		return service.updatecustomer(id, c);
		}
	
	
	
//	
	@DeleteMapping
	 public ResponseEntity<Customer>deleteCustomer(@RequestParam int id)
	 {
		 return service.deletecustomer(id);
	 }
	 
//	 
	@GetMapping("getall")
	 public ResponseEntity<List<Customer>> findall()
	 {
		return service.findall();
	 }
	
//	
	@PutMapping("addaccount")
	public ResponseEntity<Customer> addaccounttocustomer(@RequestParam int cid,@RequestParam int aid)
	{
		return service.addaccounttocustomer(cid, aid) ;
	
		}
	
//	
	@PutMapping("removeaccount")
	public ResponseEntity<Customer> removeaccounttocustomer(@RequestParam int cid ,@RequestParam int aid)
	{
		
		return service.removeaccounttocustomer(cid, aid);
	}
	
//	
	
	@GetMapping("byname")
	public ResponseEntity<List<Customer>> findbycustomername(@RequestParam String name)
	{
		
		return service.findbycustomername(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
