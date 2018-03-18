package com.senla.web.dto.lecturer;

import java.util.List;

public class LecturerUpdateDto {
	private String password;
	private Integer number;
	private String email;
	private String name;
	private List<Long> courses;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
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

	public List<Long> getCourses() {
		return courses;
	}

	public void setCourses(List<Long> courses) {
		this.courses = courses;
	}
}
