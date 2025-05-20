package com.qspiders.BankingApplication.Exception;

public class AccountTypeNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public AccountTypeNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
