package com.qspiders.BankingApplication.Exception;

public class AccountNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public AccountNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
