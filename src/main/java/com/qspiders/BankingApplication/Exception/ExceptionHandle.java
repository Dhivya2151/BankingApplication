package com.qspiders.BankingApplication.Exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

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
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String>customerlistnotfoundexception(CustomerListNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String>accountnotfoundexception(AccountNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> transactionnotfoundexception(TransactionNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> banknamenotfoundexception(BankNameNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> managernamenotfoundexception(ManagerNameNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> customernamenotfoundexception(CustomerNameNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> accounttypenotfoundexception(AccountTypeNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> transactiontypenotfoundexception(TransactionTypeNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<String> transactionaccounttypenotfoundexception(TransactionAccountTypeNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMsg(),HttpStatus.NOT_FOUND);
	}
	
//	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Map<String,String>> constraintViolationException(ConstraintViolationException cv){
		Map<String,String> data = new LinkedHashMap<String, String>();
		for(ConstraintViolation<?> violation : cv.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			data.put(field, message);
		}
		return new ResponseEntity<Map<String,String>>(data,HttpStatus.FORBIDDEN);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
