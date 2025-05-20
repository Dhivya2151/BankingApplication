package com.qspiders.BankingApplication.Exception;

public class ManagerNameNotFoundException  extends RuntimeException{
	private String msg;

	public String getMsg() {
		return msg;
	}

	public ManagerNameNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
