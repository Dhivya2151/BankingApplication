package com.qspiders.BankingApplication.Exception;

public class TransactionNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public TransactionNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
