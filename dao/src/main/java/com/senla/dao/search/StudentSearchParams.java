package com.senla.dao.search;

public class StudentSearchParams {
	private Long id;
	private String email;
	private String name;
	private String number;
	private String group;

	public StudentSearchParams(Long id,  String name, String email, String number, String group) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.number = number;
		this.group = group;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
