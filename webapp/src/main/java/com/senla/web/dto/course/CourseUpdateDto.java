package com.senla.web.dto.course;

import javax.validation.constraints.Size;

import com.senla.entity.Course;

public class CourseUpdateDto {
	@Size(max=45)
	private String name;
	@Size(max=100)
	private String description;
	private Long lecturer;

	public CourseUpdateDto(Course course) {
		this.name = course.getName();
		this.description = course.getDescription();
		if (course.getLecturer() != null) {
			this.lecturer = course.getLecturer().getId();
		}
	}

	public CourseUpdateDto() {

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

	public Long getLecturer() {
		return lecturer;
	}

	public void setLecturer(Long lecturer) {
		this.lecturer = lecturer;
	}
}
