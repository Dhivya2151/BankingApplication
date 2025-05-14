package com.qspiders.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
