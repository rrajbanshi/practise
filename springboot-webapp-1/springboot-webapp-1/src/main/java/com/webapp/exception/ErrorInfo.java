package com.webapp.exception;

import lombok.Data;

@Data
public class ErrorInfo {

	private String message;
	private Integer errorCode;
}
