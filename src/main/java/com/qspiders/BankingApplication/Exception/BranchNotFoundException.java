package com.qspiders.BankingApplication.Exception;

public class BranchNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public BranchNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	

}
