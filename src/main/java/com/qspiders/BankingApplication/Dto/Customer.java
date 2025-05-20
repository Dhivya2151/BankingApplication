package com.qspiders.BankingApplication.Dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customrerId;
	
	@NotNull(message ="customerName cannot be null" )
	@NotBlank(message ="customerName cannot be blank")
	private String customerName;
	
	@NotNull(message ="customerEmail cannot be null" )
	@NotBlank(message ="customerEmail cannot be blank")
	private String customerEmail;
	
	@NotNull(message ="customerPassword cannot be null" )
	@NotBlank(message ="customerPassword cannot be blank")
	private String customerPassword;
	
	@Min(value = 6000000000L,message ="must be greater than or equal " )
	@Max(value = 9999999999L,message ="should be " )
	private long customerContact;
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	public int getCustomrerId() {
		return customrerId;
	}
	public void setCustomrerId(int customrerId) {
		this.customrerId = customrerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public long getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
