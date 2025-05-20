package com.qspiders.BankingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	public List<Transaction> findByType(Transaction.TransactionType type);
	
//public List<Transaction>findBytransactionAccount(Transaction.TransactionType type);
}
