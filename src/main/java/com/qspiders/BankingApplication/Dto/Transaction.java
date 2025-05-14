package com.qspiders.BankingApplication.Dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactinId;
	private TransactionType type;
	private int  transactionAccount;
	private double transactionAmmount;
	@ManyToOne(cascade = CascadeType.ALL)
		private Account account;
	public enum TransactionType{
		CREDIT,
		DEBIT
	}
	public int getTransactinId() {
		return transactinId;
	}
	public void setTransactinId(int transactinId) {
		this.transactinId = transactinId;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public int getTransactionAccount() {
		return transactionAccount;
	}
	public void setTransactionAccount(int transactionAccount) {
		this.transactionAccount = transactionAccount;
	}
	public double getTransactionAmmount() {
		return transactionAmmount;
	}
	public void setTransactionAmmount(double transactionAmmount) {
		this.transactionAmmount = transactionAmmount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	

}
