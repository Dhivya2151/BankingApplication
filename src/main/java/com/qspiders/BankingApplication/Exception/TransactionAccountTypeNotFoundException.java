package com.qspiders.BankingApplication.Exception;

public class TransactionAccountTypeNotFoundException extends RuntimeException {
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public TransactionAccountTypeNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
