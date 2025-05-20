package com.qspiders.BankingApplication.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int branchid;
	
	@NotNull(message ="branch name cannot be null" )
	@NotBlank(message ="branch name cannot be blank")
	private String branchName;
	
	@NotNull(message ="branchIFSC code cannot be null" )
	@NotBlank(message ="branchIFSC code cannot be blank")
	private String branchIFSCCode;
	
	@Min(value = 6000000000L,message ="must be greater than or equal " )
	@Max(value = 9999999999L,message ="should be " )
	private long branchContact;
	
	@NotNull(message ="branch city cannot be null" )
	@NotBlank(message ="branch city cannot be blank")
	private String branchCity; 
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Bank bank;
	@OneToOne(cascade = CascadeType.ALL)
	 @JsonManagedReference
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
