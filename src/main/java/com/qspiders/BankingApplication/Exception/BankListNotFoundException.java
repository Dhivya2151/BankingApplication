package com.qspiders.BankingApplication.Exception;

public class BankListNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public BankListNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
