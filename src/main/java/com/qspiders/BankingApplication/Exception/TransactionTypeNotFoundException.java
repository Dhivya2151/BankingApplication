package com.qspiders.BankingApplication.Exception;

public class TransactionTypeNotFoundException extends RuntimeException {
	
		private String message;

		public String getMessage() {
			return message;
		}

		public TransactionTypeNotFoundException(String message) {
			super();
			this.message = message;
		}
		
		
	
}
