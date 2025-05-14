package com.qspiders.BankingApplication.Exception;

public class ManagerNotFoundException extends RuntimeException{
	private String msg;

	public String getMsg() {
		return msg;
	}

	public ManagerNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	

}
