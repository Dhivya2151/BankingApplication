package com.qspiders.BankingApplication.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerId;
	
	@NotNull(message ="managerName cannot be null" )
	@NotBlank(message ="managerName cannot be blank")
	private String managerName;
	
	@NotNull(message ="manageremail cannot be null" )
	@NotBlank(message ="manageremail cannot be blank")
	private String managerEmail;
	
	@NotNull(message ="managerpassword cannot be null" )
	@NotBlank(message ="managerpassword cannot be blank")
	private String managerPassword;
	
	@Min(value = 6000000000L,message ="must be greater than or equal " )
	@Max(value = 9999999999L,message ="should be " )
	private long managerContact;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Branch branch;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public long getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(long managerContact) {
		this.managerContact = managerContact;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
	

}
