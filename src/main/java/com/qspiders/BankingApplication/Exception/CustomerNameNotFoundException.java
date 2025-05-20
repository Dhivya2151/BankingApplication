package com.qspiders.BankingApplication.Exception;

public class CustomerNameNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public CustomerNameNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
