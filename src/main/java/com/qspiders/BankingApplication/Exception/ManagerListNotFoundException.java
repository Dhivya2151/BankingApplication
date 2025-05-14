package com.qspiders.BankingApplication.Exception;

public class ManagerListNotFoundException extends RuntimeException {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public ManagerListNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
