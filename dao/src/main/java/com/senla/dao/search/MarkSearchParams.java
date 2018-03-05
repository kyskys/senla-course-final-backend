package com.senla.dao.search;

public class MarkSearchParams {
	private Long id;
	private String pair;
	private String student;

	public MarkSearchParams(Long id, String pair, String student) {
		super();
		this.id = id;
		this.pair = pair;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}
}
