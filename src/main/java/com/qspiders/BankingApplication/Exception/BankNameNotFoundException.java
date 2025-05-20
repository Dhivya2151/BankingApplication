package com.qspiders.BankingApplication.Exception;

public class BankNameNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public BankNameNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
