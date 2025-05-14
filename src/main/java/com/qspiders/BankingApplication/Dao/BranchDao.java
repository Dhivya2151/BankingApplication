package com.qspiders.BankingApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspiders.BankingApplication.Dto.Branch;
import com.qspiders.BankingApplication.Repository.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo repo;
//	1. save method
	public Branch savebranch(Branch branch)
	{
		return repo.save(branch);
	}
	
//	2.find branch by id
	public Branch findbybranch(int id)
	{
		Optional<Branch> op = repo.findById(id);
		{
			if(op.isPresent())
			{
				return op.get();
				
			}
			else
			{
				return null;
			}
		}
	}

//	3.update method
	public Branch updateBank(int id,Branch b)
	{
		Branch branch = findbybranch(id);
		if(branch!=null)
		{
			if(b.getBranchName()!=null)
			{
				branch.setBranchName(b.getBranchName());
			}
			if(b.getBranchIFSCCode()!=null)
			{
				branch.setBranchIFSCCode(b.getBranchIFSCCode());
			}
			if(b.getBranchContact()!=0l)
			{
				branch.setBranchContact(b.getBranchContact());
			}
			if(b.getBranchCity()!=null)
			{
				branch.setBranchCity(b.getBranchCity());
			}
			
		}
		else {
			return null;
	}
		return repo.save(branch);
	}
			
//	4.delete
	
	public Branch deletebranch(int id)
	{
		Branch branch = findbybranch(id);
		if(branch!=null)
		{
			repo.delete(branch);
			return branch;
		}
		else
		{
			return null;
		}
	}
	
//	5.find all
	public List<Branch> findallbranch()
	{
		return repo.findAll();
	}
	{
		
	}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
}
