package com.qspiders.BankingApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qspiders.BankingApplication.Dao.Bankdao;
import com.qspiders.BankingApplication.Dao.BranchDao;
import com.qspiders.BankingApplication.Dao.CustomerDao;
import com.qspiders.BankingApplication.Dto.Bank;
import com.qspiders.BankingApplication.Dto.Branch;
import com.qspiders.BankingApplication.Dto.Customer;
import com.qspiders.BankingApplication.Exception.BankNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchListNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;

@Service
public class BranchService {
	@Autowired	
BranchDao dao;
	@Autowired	
	Bankdao bdao;
	@Autowired
	CustomerDao cdao;
//	
	public  ResponseEntity<Branch> savebranch(Branch b)
	{
		return  new ResponseEntity<Branch>( dao.savebranch(b),HttpStatus.CREATED);
	}
	
//	
	public  ResponseEntity<Branch> findbranch(int id)
	{
		Branch branch = dao.findbybranch(id);
		if(branch!=null)
		{
			return new ResponseEntity<Branch>(branch,HttpStatus.FOUND);
		}
		else
		{
			throw new BranchNotFoundException("branch not found for the given id");
		}
	}
	
//	
	public ResponseEntity<Branch> updatebranch(int id, Branch b)
	
	{
	Branch branch = dao.updateBranch(id, b);
	if(branch!=null)
	{
		return  new ResponseEntity<Branch>(branch,HttpStatus.FOUND);
	}
	else
	{
		throw new BranchNotFoundException("branch not found for the given id");
	}
	}
	
//	
	 public ResponseEntity<Branch>deletebranch(int id)
	 {
		 Branch branch = dao.deletebranch(id);
		 if(branch!=null)
		 {
			 return  new ResponseEntity<Branch>(branch,HttpStatus.OK);
		 }
		 else
		 {
			 throw new BranchNotFoundException("branch not found for the given id");
		 }
	 }
	 
//	 
	 public ResponseEntity<List<Branch>> findall()
	 {
		 List<Branch> list = dao.findallbranch();
		 if(list!=null)
		 {
			 return new ResponseEntity<List<Branch>>(list,HttpStatus.OK);
		 }
		 else
		 {
			 throw new BranchListNotFoundException("branch not found for the given list");
		 }
	 }
	
//	 
	 
	 public ResponseEntity<Branch> addbanktobranch(int bankid,int branchid)
	 {
		 Branch dbbranch = dao.findbybranch(branchid);
		 Bank dbbank = bdao.findBank(bankid);
		 if(dbbranch!=null)
		 {
			 if(dbbank!=null)
			 {
				 dbbranch.setBank(dbbank);
				 dbbank.setBranch(dbbranch);
				Branch upbranch = dao.updateBranch(branchid, dbbranch);
				return  new ResponseEntity<Branch>(upbranch,HttpStatus.OK);
						
						}
			 throw new BranchNotFoundException("branch not found for the given id") ;
			
		 }
		 throw new BankNotFoundException("bank not found for the given id") ;
		 
	 }
	 
//	 
	 
	 public ResponseEntity<Branch> removebankfrombranch(int bankid,int branchid)
	 {
		 Branch dbbranch = dao.findbybranch(branchid);
		 Bank dbbank = bdao.findBank(bankid);
		 if(dbbranch!=null)
		 {
			 if(dbbank!=null)
			 {
				 dbbranch.setBank(null);
				 dbbank.setBranch(null);
				Branch upbranch = dao.updateBranch(branchid, dbbranch);
				return  new ResponseEntity<Branch>(upbranch,HttpStatus.OK);
						
						}
			 throw new BranchNotFoundException("branch not found for the given id") ;
			
		 }
		 throw new BankNotFoundException("bank not found for the given id") ;
		 
	 }
	 
//	 
	 
	 public ResponseEntity addcustomertobranch(int bid,Customer c)
	 {
		 Branch dbbranch = dao.findbybranch(bid);
		 if(dbbranch!=null)
		 {
			 if(c!=null)
			 {
			 dbbranch.getCustomer().add(c);
			return  new ResponseEntity(dao.updateBranch(bid, dbbranch),HttpStatus.OK);
			 }
			 throw new CustomerNotFoundException("branch not found ") ; 
		 }
		 throw new BranchNotFoundException("branch not found for the given id") ;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
