package com.senla.web.dto;

import com.senla.entity.Student;

public class GroupStudentDto {
	private Long id;
	private String email;
	private String name;
	private Integer number;
	private String login;

	public GroupStudentDto() {

	}

	public GroupStudentDto(Student student) {
		this.id = student.getId();
		this.login = student.getLogin();
		this.name = student.getName();
		this.email = student.getEmail();
		this.number = student.getNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
