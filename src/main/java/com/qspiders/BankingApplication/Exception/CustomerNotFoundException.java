package com.qspiders.BankingApplication.Exception;

public class CustomerNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public CustomerNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
