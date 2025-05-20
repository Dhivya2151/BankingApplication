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
import com.qspiders.BankingApplication.Dao.ManagerDao;
import com.qspiders.BankingApplication.Dto.Bank;
import com.qspiders.BankingApplication.Dto.Branch;
import com.qspiders.BankingApplication.Dto.Customer;
import com.qspiders.BankingApplication.Dto.Manager;
import com.qspiders.BankingApplication.Exception.BankNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchListNotFoundException;
import com.qspiders.BankingApplication.Exception.BranchNotFoundException;
import com.qspiders.BankingApplication.Exception.CustomerNotFoundException;
import com.qspiders.BankingApplication.Exception.ManagerNotFoundException;

@Service
public class BranchService {
	@Autowired	
BranchDao dao;
	@Autowired	
	Bankdao bdao;
	@Autowired
	CustomerDao cdao;
	@Autowired
	ManagerDao mdao;
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
	 
	 public ResponseEntity<Branch> addcustomertobranch(int bid,int  cid)
	 {
		 Branch dbbranch = dao.findbybranch(bid);
		 					Customer dbcustomer = cdao.findbycustomer(cid);
		 if(dbbranch!=null)
		 {
			 if(dbcustomer!=null)
			 {
			 dbbranch.getCustomer().add(dbcustomer);
			return  new ResponseEntity(dao.updateBranch(bid, dbbranch),HttpStatus.OK);
			 }
			 throw new CustomerNotFoundException("Customers not found for the given id ") ; 
		 }
		 throw new BranchNotFoundException("branch not found for the given id") ;
	 }
	 
//	 
	
	 public ResponseEntity<Branch> removecustomerfrombranch(int bid,int cid)
	 {
		 Branch dbbranch = dao.findbybranch(bid);
		 Customer dbcustomer = cdao.findbycustomer(cid);
    if(dbbranch!=null)
		 {
			 if(dbcustomer!=null)
			 {
			 dbbranch.getCustomer().remove(dbcustomer);
			return  new ResponseEntity(dao.updateBranch(bid, dbbranch),HttpStatus.OK);
			 }
			 throw new CustomerNotFoundException("Customer not found for the given id ") ; 
		 }
		 throw new BranchNotFoundException("branch not found for the given id") ;
	 }
	
//	 
	 
	 public ResponseEntity<Branch> addmanagertobranch(int branchid,int managerid)
	 {
		 Branch dbbranch = dao.findbybranch(branchid);
		 Manager dbmanager = mdao.findbymanager(managerid);
		 if(dbbranch!=null)
		 {
			 if(dbmanager!=null)
			 {
				 dbbranch.setManager(dbmanager);
				 dbmanager.setBranch(dbbranch);
				Branch upbranch = dao.updateBranch(branchid, dbbranch);
				return  new ResponseEntity<Branch>(upbranch,HttpStatus.OK);
						
						}
			 throw new BranchNotFoundException("branch not found for the given id") ;
			
		 }
		 throw new ManagerNotFoundException("Manager not found for the given id") ;
		 
	 }
	
//	 
	 
	 public ResponseEntity<Branch> removemanagertobranch(int branchid,int managerid)
	 {
		 Branch dbbranch = dao.findbybranch(branchid);
		 Manager dbmanager = mdao.findbymanager(managerid);
		 if(dbbranch!=null)
		 {
			 if(dbmanager!=null)
			 {
				 dbbranch.setManager(null);
				 dbmanager.setBranch(null);
				Branch upbranch = dao.updateBranch(branchid, dbbranch);
				return  new ResponseEntity<Branch>(upbranch,HttpStatus.OK);
						
						}
			 throw new BranchNotFoundException("branch not found for the given id") ;
			
		 }
		 throw new ManagerNotFoundException("Manager not found for the given id") ;
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
