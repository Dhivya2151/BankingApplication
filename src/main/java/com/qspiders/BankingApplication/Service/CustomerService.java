package com.qspiders.BankingApplication.Service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qspiders.BankingApplication.Dao.CustomerDao;
import com.qspiders.BankingApplication.Dto.Customer;
import com.qspiders.BankingApplication.Exception.CustomerListNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;
import com.qspiders.BankingApplication.Exception.ManagerNotFoundException;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;
	
//	
	public ResponseEntity<Customer> savecustomer(Customer c)
	{
		return new ResponseEntity<Customer>(dao.savemanager(c),HttpStatus.CREATED);
	}
	
//	
	
	public ResponseEntity<Customer> findcustomer(int id)
	{
		Customer dbcustomer = dao.findbycustomer(id);
		if(dbcustomer!=null)
		{
			return new ResponseEntity<Customer>(dbcustomer,HttpStatus.FOUND);
		}
		else
		{
			throw new CustomerNotFoundException("Customer not found for the given id");
			
		}
	}
	
//	
	
	public ResponseEntity<Customer> deletecustomer(int id)
	{
		Customer dbcustomer = dao.deletecustomer(id);
		if(dbcustomer!=null)
		{
			return new ResponseEntity<Customer>(dbcustomer,HttpStatus.OK); 
		}
		else {
			throw new CustomerNotFoundException("Customer not found for the given id");
			
		}
	}
	
//	
	public ResponseEntity<Customer>updatecustomer(int id,Customer c)
	{
		Customer dbcustomer = dao.updatemanager(id, c);
		if(dbcustomer!=null)
		{
			return new ResponseEntity<Customer>(dbcustomer,HttpStatus.OK); 
		}
		else
		{
			throw new CustomerNotFoundException("Customer not found for the given id");
		}
	}
	
//	
	
	public ResponseEntity<List<Customer>> findall()
	{
		List<Customer> list = dao.findall();
		if(list!=null)
		{
			return new ResponseEntity<List<Customer>>(list,HttpStatus.OK); 
		}
		else
		{
			throw new CustomerListNotFoundException("Customer not found for the given List");
		}
	}
	
//	
	
//	public Customer addaccounttocustomer(int cid,int aid)
//	{
//		dao.
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
