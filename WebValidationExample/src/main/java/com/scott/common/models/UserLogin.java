package com.scott.common.models;
import org.hibernate.validator.constraints.NotEmpty;

public class UserLogin {

	@NotEmpty(message = "Please enter a Username!") 
	private String username;
	@NotEmpty(message = "Please enter a Password!") 
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}


