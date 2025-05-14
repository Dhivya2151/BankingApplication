package com.qspiders.BankingApplication.Exception;

public class BranchListNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public BranchListNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
