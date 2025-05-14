package com.qspiders.BankingApplication.Dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int branchid;
	private String branchName;
	private String branchIFSCCode;
	private long branchContact;
	private String branchCity; 
	@OneToOne(cascade = CascadeType.ALL)	
	private Bank bank;
	@OneToOne(cascade = CascadeType.ALL)
	private Manager manager;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Customer>customer;
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchIFSCCode() {
		return branchIFSCCode;
	}
	public void setBranchIFSCCode(String branchIFSCCode) {
		this.branchIFSCCode = branchIFSCCode;
	}
	public long getBranchContact() {
		return branchContact;
	}
	public void setBranchContact(long branchContact) {
		this.branchContact = branchContact;
	}
	public String getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	
	

}
