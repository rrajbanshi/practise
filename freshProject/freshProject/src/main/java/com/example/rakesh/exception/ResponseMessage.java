package com.example.rakesh.exception;

public class ResponseMessage {

	private String message;
	private int errorCode;
	
	public void setMessage(String message) {
		this.message = message;
	}
	public void setErrorCode(int code) {
		this.errorCode = code;
	}
	public int getErrorCode() {
		return this.errorCode;
	}
	public String getMessage() {
		return this.message;
	}
}
