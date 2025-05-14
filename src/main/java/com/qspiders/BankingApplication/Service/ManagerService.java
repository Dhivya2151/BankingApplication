package com.qspiders.BankingApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qspiders.BankingApplication.Dao.BranchDao;
import com.qspiders.BankingApplication.Dao.ManagerDao;
import com.qspiders.BankingApplication.Dto.Branch;
import com.qspiders.BankingApplication.Dto.Manager;
import com.qspiders.BankingApplication.Exception.BranchNotFoundException;
import com.qspiders.BankingApplication.Exception.ManagerListNotFoundException;
import com.qspiders.BankingApplication.Exception.ManagerNotFoundException;

@Service
public class ManagerService {
	@Autowired	
	ManagerDao dao;
	@Autowired
	BranchDao bdao;
	
//	
	public  ResponseEntity<Manager> savebranch(Manager m)
	{
		return  new ResponseEntity<Manager>( dao.savemanager(m),HttpStatus.CREATED);
	}
	
//	
	public  ResponseEntity<Manager> findbranch(int id)
	{
		Manager man = dao.findbymanager(id);
		if(man!=null)
		{
			return new ResponseEntity<Manager>(man,HttpStatus.FOUND);
		}
		else
		{
			throw new ManagerNotFoundException("Manager not found for the given id");
		}
	}
	
//	
	public ResponseEntity<Manager> updatebranch(int id, Manager m)
	
	{
		Manager man = dao.updatemanager(id, m);
	if(man!=null)
	{
		return  new ResponseEntity<Manager>(man,HttpStatus.FOUND);
	}
	else
	{
		throw new ManagerNotFoundException("Manager not found for the given id");
	}
	}
	
//	
	 public ResponseEntity<Manager>deletebranch(int id)
	 {
		 Manager man = dao.deletemanager(id);
		 if(man!=null)
		 {
			 return  new ResponseEntity<Manager>(man,HttpStatus.OK);
		 }
		 else
		 {
			 throw new ManagerNotFoundException("Manager not found for the given id");
		 }
	 }
	 
//	 
	 public ResponseEntity<List<Manager>> findall()
	 {
		 List<Manager> list = dao.findall();
		 if(list!=null)
		 {
			 return new ResponseEntity<List<Manager>>(list,HttpStatus.OK);
		 }
		 else
		 {
			 throw new ManagerListNotFoundException("Manager not found for the given list");
		 }
	 }
	
//	 
	 
	 public ResponseEntity<Manager> addmanagertobranch(int managerid,int branchid)
	 {
		 Branch dbbranch = bdao.findbybranch(branchid);
		Manager dbmanager = dao.findbymanager(managerid);
		 if(dbmanager!=null)
		 {
			 if(dbbranch!=null)
			 {
				 dbmanager.setBranch(dbbranch);
				dbbranch.setManager(dbmanager);
			 Manager updatemanager = dao.updatemanager(managerid, dbmanager);
				return  new ResponseEntity<Manager>(updatemanager,HttpStatus.OK);
						
						}
			 throw new BranchNotFoundException("branch not found for the given id") ;
			
		 }
		 throw new ManagerNotFoundException("Manager not found for the given id") ;
		 
	 }
	 
//	 
	 
	 public ResponseEntity<Manager> removemanagerfrombranch(int managerid,int branchid)
	 {
		 Branch dbbranch = bdao.findbybranch(branchid);
		Manager dbmanager = dao.findbymanager(managerid);
		 if(dbmanager!=null)
		 {
			 if(dbbranch!=null)
			 {
				 dbmanager.setBranch(null);
				dbbranch.setManager(null);
			 Manager updatemanager = dao.updatemanager(managerid, dbmanager);
				return  new ResponseEntity<Manager>(updatemanager,HttpStatus.OK);
						
						}
			 throw new BranchNotFoundException("branch not found for the given id") ;
			
		 }
		 throw new ManagerNotFoundException("Manager not found for the given id") ;
		 
	 }
	 
	 
	
	 

	
	

}
