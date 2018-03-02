package com.senla.dao.search;

public class LecturerSearchParams {
	private Long id;
	private String email;
	private String name;
	private Integer number;

	public LecturerSearchParams(Long id, String email, String name, Integer number) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.number = number;
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

}
