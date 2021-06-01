package com.appsdevlopersblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message="First Name cann't be null")
	@Size(min=2,message="Fist Name should have min 2 characters")
	private String firstname;
	
	@NotNull(message="Last Name cann't be null")
	@Size(min=2,message="Last Name should have min 2 characters")
	private String lastname;
	
	@NotNull(message="Email cann't be null")
	@Email
	private String email;
	
	@NotNull(message="Password cann't be null")
	@Size(min=8,max=16,message="Password length must be greather than 8 and less than 16")
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
