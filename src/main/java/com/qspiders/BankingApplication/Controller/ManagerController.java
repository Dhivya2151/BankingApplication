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

import com.qspiders.BankingApplication.Dto.Branch;
import com.qspiders.BankingApplication.Dto.Manager;
import com.qspiders.BankingApplication.Exception.BranchNotFoundException;
import com.qspiders.BankingApplication.Exception.ManagerNotFoundException;
import com.qspiders.BankingApplication.Service.ManagerService;

@RestController
@RequestMapping("manager")
public class ManagerController {
	@Autowired
	ManagerService service;
	
	@PostMapping
	public  ResponseEntity<Manager> saveManager(@RequestBody Manager b)
	{
		return  service.savemanager(b);
	}
	
//	
	@GetMapping	
	public  ResponseEntity<Manager> findManager(@RequestParam  int id)
	{
		 return service.findmanager(id);
	}
	
//	
	@PutMapping
		public ResponseEntity<Manager> updateManager(@RequestParam  int id,@RequestBody Manager b)
		{
		return service.updatemanager(id, b);
		}
	
	
	
//	
	@DeleteMapping
	 public ResponseEntity<Manager>deleteManager(@RequestParam int id)
	 {
		 return service.deletemanager(id);
	 }
	 
//	 
	@GetMapping("getall")
	 public ResponseEntity<List<Manager>> findall()
	 {
		return service.findall();
	 }
	
//	
	@PutMapping("addmanager")	
	 public ResponseEntity<Manager> addmanagertobranch(@RequestParam int managerid,@RequestParam int branchid)
	 {
		 return service.addmanagertobranch(managerid, branchid);
		 
	 }
	 
//	 
	
	@PutMapping("removemanager")	 
	 public ResponseEntity<Manager> removemanagerfrombranch(@RequestParam int managerid,@RequestParam int branchid)
	 {
		return service.removemanagerfrombranch(managerid, branchid);
		 
	 }
	
//	
	@GetMapping("byname")
	public ResponseEntity<List<Manager>> findbyname( @RequestParam String name){
		return service.findbyname(name);
	}
	 

}
