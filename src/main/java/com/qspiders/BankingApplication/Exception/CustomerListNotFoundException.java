package com.qspiders.BankingApplication.Exception;

public class CustomerListNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public CustomerListNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
