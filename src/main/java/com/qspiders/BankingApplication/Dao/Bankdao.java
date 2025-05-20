package com.qspiders.BankingApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspiders.BankingApplication.Dto.Bank;
import com.qspiders.BankingApplication.Repository.BankRepo;

@Repository
public class Bankdao {
	@Autowired
	BankRepo repo;
	
//1	save method
	public  Bank savebank(Bank b)
	{
		return repo.save(b);
		
	}
	
//2.	find  bank by id method
	public Bank findBank(int id)
	{
	 Optional<Bank> op=repo.findById(id);	
	 if(op.isPresent())
	 {
		return op.get();
	 }
	 return null;
	}
//	3.delete bank by id
	public Bank deletebank(int id)
	{
		Bank bank = findBank(id);
		
		if(bank!=null)
		{
			return bank;
		}
		else
		{
			return null;
		}
	}
	
//	4.update bank
	public Bank updateBank(int id,Bank bank)
	{
		Bank b = findBank(id);
		if(b!=null)
		{
			if(bank.getBankName()!=null)
			{
				b.setBankName(bank.getBankName());
			}
			if(bank.getHeadOffice()!=null)
			{
				b.setHeadOffice(bank.getHeadOffice());
			}
			if(bank.getBranch()!=null)
			{
				b.setBranch(bank.getBranch());
			}
			return repo.save(b);
		}
		else
		{
			return null;
		}
		
		
	}
	
	
	
//5.list of bank
	
	public List<Bank> findall()
	{
		return repo.findAll();
	}
	
	
//	6.findbyname
	
	
	public List<Bank> findbyname(String name){
		return repo.findBybankName(name);
	}
	
	
	
	
	
	
	
	
	
}
