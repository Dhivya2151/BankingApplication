package com.qspiders.BankingApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.qspiders.BankingApplication.Dao.Bankdao;
import com.qspiders.BankingApplication.Dao.BranchDao;
import com.qspiders.BankingApplication.Dto.Bank;
import com.qspiders.BankingApplication.Dto.Branch;
import com.qspiders.BankingApplication.Exception.BankNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchNotFoundException;
@Repository
public class BankService {
	@Autowired
	Bankdao dao;
	@Autowired 
	BranchDao bdao;
//
	public ResponseEntity<Bank> savebank(Bank b)
	{
		return  new ResponseEntity<Bank>( dao.savebank(b),HttpStatus.CREATED);
	}
	
//	
	public  ResponseEntity<Bank>  findbank(int id)
	{
		Bank dbbank = dao.findBank(id);
		if(dbbank!=null)
		{
			return new  ResponseEntity<Bank>(dbbank,HttpStatus.FOUND);
		}
		else
		{
			 throw new BankNotFoundException("bank not found for the given id") ;
		}
	}
	
//	
	
	public ResponseEntity<Bank> deletebank(int id)
	{
		Bank dbbank = dao.deletebank(id);
		if(dbbank!=null)
		{
			return new  ResponseEntity<Bank>(dbbank,HttpStatus.OK);
		}
		else
		{
			throw new BankNotFoundException("bank not found for the given id") ;
		}
	}
	
//	
	public ResponseEntity<Bank> updatebank(int id, Bank b )
	{
		Bank upbank = dao.updateBank(id, b);
		if(upbank!=null)
		{
			return new ResponseEntity<Bank>(upbank,HttpStatus.OK);
		}
		else
		{
			throw new BankNotFoundException("bank not found for the given id") ;
		}
		
	}
	
//	
	public List<Bank> findall()
	{
		return dao.findall();
	}
	
//	add branch to bank
	
	public  ResponseEntity<Bank> addbranchtobank(int bankid,int baranchid)
	{
		Bank dbbank = dao.findBank(bankid);
		Branch dbbranch = bdao.findbybranch(baranchid);
		if(dbbank!=null)
		{
			if(dbbranch!=null) {
				 dbbank.setBranch(dbbranch);
				 dbbranch.setBank(dbbank);
				 Bank updateBank = dao.updateBank(bankid, dbbank);
				 return  new ResponseEntity<Bank>(updateBank,HttpStatus.OK);
			}
			throw new BranchNotFoundException("bank not found for the given id") ;
		}
		throw new BankNotFoundException("bank not found for the given id") ;
		
		
	}
	
	
//	remove branch from bank
	
	public  Bank removebranchfrombank( int bankid,int baranchid)
	{
		Bank dbbank = dao.findBank(bankid);
		Branch dbbranch = bdao.findbybranch(baranchid);
		if(dbbank!=null)
		{
			if(dbbranch!=null) {
				 dbbank.setBranch(null);
				 dbbranch.setBank(null);
				 return dao.updateBank(bankid, dbbank);
			}
			throw new BranchNotFoundException("bank not found for the given id") ;
		}
		throw new BankNotFoundException("bank not found for the given id") ;
		
		
		
	}
	
	
}
