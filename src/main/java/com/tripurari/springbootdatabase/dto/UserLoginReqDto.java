package com.tripurari.springbootdatabase.dto;

// Data Transfer object
public class UserLoginReqDto {

	private String email;
	private String password;
	
	public UserLoginReqDto(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
