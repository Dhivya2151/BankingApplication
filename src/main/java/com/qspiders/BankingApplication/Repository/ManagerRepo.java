package com.qspiders.BankingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qspiders.BankingApplication.Dto.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
	
	public List< Manager> findBymanagerName(String name);

}
