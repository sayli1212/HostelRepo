package com.capgemini.HostelManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HostellorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	String message;

	
	public HostellorNotFoundException(String message) {
	
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
