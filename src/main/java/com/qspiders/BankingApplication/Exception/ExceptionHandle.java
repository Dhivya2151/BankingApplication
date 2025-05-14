package com.qspiders.BankingApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> banknotfoundexception(BankNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> banklistnotfoundexception(BankListNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> branchlistnotfoundexception(BranchListNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> managernotfoundexception(ManagerNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> managerlidtnotfoundexception(ManagerListNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String>customernotfoundexception(CustomerNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<String>customerlistnotfoundexception(CustomerListNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
