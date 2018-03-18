package com.senla.web.dto.course;

import com.senla.entity.Course;

public class CourseGetDto {
	private Long id;
	private String name;
	private String description;
	private String lecturer;

	public CourseGetDto(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.description = course.getDescription();
		if (course.getLecturer() != null) {
			this.lecturer = course.getLecturer().getName();
		}
	}

	public CourseGetDto() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
}
