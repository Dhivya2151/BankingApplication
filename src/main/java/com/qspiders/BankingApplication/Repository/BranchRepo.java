package com.qspiders.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {

}
