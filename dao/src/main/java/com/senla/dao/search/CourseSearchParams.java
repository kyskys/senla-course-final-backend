package com.senla.dao.search;

public class CourseSearchParams {
	private Long id;
	private String name;
	private String lecturer;

	public CourseSearchParams(Long id, String name, String lecturer) {
		super();
		this.id = id;
		this.name = name;
		this.lecturer = lecturer;
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

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
}
