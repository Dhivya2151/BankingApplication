package com.qspiders.BankingApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspiders.BankingApplication.Dto.Customer;
import com.qspiders.BankingApplication.Repository.CustomerRepo;


@Repository
public class CustomerDao {

	@Autowired
	CustomerRepo repo;
//	1.save
	public  Customer  savecustomer(Customer c)
	{
		return repo.save(c);
	}

//	2.find Customer
	public Customer findbycustomer(int id)
	{
		Optional<Customer> op = repo.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			return null;
		}
	}

//	3.delete
	public Customer deletecustomer(int id)
	{
		Customer customer = findbycustomer(id);
		if(customer!=null)
		{
			repo.delete(customer);
			return customer;
		}
		else
		{
			return null;
		}
			
	}
	
//	4.update
	public Customer updatecustomer(int id,Customer c)
	{
		Customer customer = findbycustomer(id);
		if(customer!=null)
		{
			if(c.getCustomerName()!=null)
			{
				customer.setCustomerName(c.getCustomerName());
			}
			if(c.getCustomerEmail()!=null)
			{
				customer.setCustomerEmail(c.getCustomerEmail());
			}
			if(c.getCustomerPassword()!=null)
			{
				customer.setCustomerPassword(c.getCustomerPassword());
			}
			if(c.getCustomerContact()!=0l)
			{
				customer.setCustomerContact(c.getCustomerContact());
			}
			return repo.save(customer);
		}
		else
		{
			return null;
		}
	}
	
//5.find all
	public List<Customer> findall()
	{
		return repo.findAll();
	}
	
//	6.findbyname
	
	public List<Customer> findbycustomername(String name)
	{
		return repo.findBycustomerName(name);
	}
}



