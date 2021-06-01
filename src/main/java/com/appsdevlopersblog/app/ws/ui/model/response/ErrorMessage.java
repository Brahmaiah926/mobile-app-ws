package com.appsdevlopersblog.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {
	public Date timestamp;
	public String message;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(Date timestamp,String message) {
		this.timestamp = timestamp;
		this.message = message;
		
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
