package com.mayamcof.exception;

public class AuthenticationException extends RuntimeException{

	
	private String message;	

	private String errorCode;
	
	private String champ;
	
	
	public AuthenticationException(String message, String errorCode, String champ) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
		this.champ = champ;
	}
	
	public AuthenticationException(String message, String errorCode) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}
	
	public AuthenticationException(String message) {
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getChamp() {
		return champ;
	}

	public void setChamp(String champ) {
		this.champ = champ;
	}

	
	
}
