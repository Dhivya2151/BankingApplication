package com.qspiders.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
