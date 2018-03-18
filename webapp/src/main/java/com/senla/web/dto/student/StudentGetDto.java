package com.senla.web.dto.student;

import com.senla.entity.Student;

public class StudentGetDto {
	private Long id;
	private String number;
	private String email;
	private String name;
	private String group;

	public StudentGetDto() {

	}

	public StudentGetDto(Student student) {
		this.id = student.getId();
		this.number = student.getNumber();
		this.email = student.getEmail();
		this.name = student.getName();
		if (student.getGroup() != null) {
			this.group = student.getGroup().getName();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
