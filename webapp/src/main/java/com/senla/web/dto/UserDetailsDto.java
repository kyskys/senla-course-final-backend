package com.senla.web.dto;

import javax.validation.constraints.Size;

import com.senla.entity.User;

public class UserDetailsDto {
	@Size(max=45)
	private String email;
	@Size(max=45)
	private String number;
	@Size(max=45)
	private String name;

	public UserDetailsDto() {

	}

	public UserDetailsDto(User user) {
		this.email = user.getEmail();
		this.number = user.getNumber();
		this.name = user.getName();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
