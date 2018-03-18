package com.senla.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterDto {
	@NotBlank
	@Size(min = 1, max = 16)
	private String login;
	@NotBlank
	@Size(min = 8, max = 45)
	private String password;
	private String number;
	@Size(max = 45)
	private String email;
	@NotBlank
	@Size(max = 45)
	private String name;
	@NotBlank
	private String role;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
