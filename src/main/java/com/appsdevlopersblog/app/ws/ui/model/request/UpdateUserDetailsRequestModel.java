package com.appsdevlopersblog.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@NotNull(message="First Name cann't be null")
	@Size(min=2,message="Fist Name should have min 2 characters")
	private String firstName;
	
	@NotNull(message="Last Name cann't be null")
	@Size(min=2,message="Last Name should have min 2 characters")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
