package com.qspiders.BankingApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspiders.BankingApplication.Dto.Bank;
import com.qspiders.BankingApplication.Dto.Manager;
import com.qspiders.BankingApplication.Repository.ManagerRepo;
@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo repo;
//	1.save
	public  Manager  savemanager(Manager m)
	{
		return repo.save(m);
	}

//	2.find manager
	public Manager findbymanager(int id)
	{
		Optional<Manager> op = repo.findById(id);
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
	public Manager deletemanager(int id)
	{
		Manager manager = findbymanager(id);
		if(manager!=null)
		{
			repo.delete(manager);
			return manager;
		}
		else
		{
			return null;
		}
			
	}
	
//	4.update
	public Manager updatemanager(int id,Manager m)
	{
		Manager manager = findbymanager(id);
		if(manager!=null)
		{
			if(m.getManagerName()!=null)
			{
				manager.setManagerName(m.getManagerName());
			}
			if(m.getManagerEmail()!=null)
			{
				manager.setManagerEmail(m.getManagerEmail());
			}
			if(m.getManagerPassword()!=null)
			{
				manager.setManagerPassword(m.getManagerPassword());
			}
			if(m.getManagerContact()!=0l)
			{
				manager.setManagerContact(m.getManagerContact());
			}
			return repo.save(manager);
		}
		else
		{
			return null;
		}
	}
	
//5.find all
	public List<Manager> findall()
	{
		return repo.findAll();
	}
	
	
//	6.findby name
	public List<Manager> findbyname(String name){
		return repo.findBymanagerName(name);
	}
	
	
}

