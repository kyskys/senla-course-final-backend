package com.senla.dao.search;

public class LectionSearchParams {
	private Long id;
	private String name;
	private String pair;
	private String course;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public LectionSearchParams(Long id, String name, String pair, String course) {
		super();
		this.id = id;
		this.name = name;
		this.pair = pair;
		this.course=course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}
}
