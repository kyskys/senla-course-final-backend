package com.senla.web.dto.lecturer;

import com.senla.entity.Lecturer;

public class LecturerGetDto {
	private Long id;
	private String number;
	private String email;
	private String name;

	public LecturerGetDto() {

	}

	public LecturerGetDto(Lecturer lecturer) {
		this.id = lecturer.getId();
		this.number = lecturer.getNumber();
		this.email = lecturer.getEmail();
		this.name = lecturer.getName();
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

}
