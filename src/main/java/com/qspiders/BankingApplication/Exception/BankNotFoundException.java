package com.qspiders.BankingApplication.Exception;

public class BankNotFoundException extends RuntimeException  {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public BankNotFoundException(String message) {
		super();
		this.message = message;
	}
	

}
